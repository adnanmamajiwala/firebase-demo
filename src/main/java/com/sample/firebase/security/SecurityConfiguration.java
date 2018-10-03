package com.sample.firebase.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableWebFluxSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final FirebaseAuthenticationProvider firebaseAuthenticationProvider;
    private final FirebaseReactiveAuthenticationManager firebaseReactiveAuthenticationManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(firebaseAuthenticationProvider);
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                    .antMatchers("/vendor/**",  "/javascripts/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                .and()
                    .logout()
                        .permitAll();
        // @formatter:on
    }



//    @Bean
//    @Order(2)
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        // @formatter:off
//      return http.httpBasic().and()
//                .csrf().disable()
//                .authorizeExchange().anyExchange().permitAll()

        return http
                .authorizeExchange()
                    .pathMatchers("/vendor/**",  "/javascripts/**").permitAll()
                    .anyExchange().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .authenticationManager(firebaseReactiveAuthenticationManager)
                .build();
        // @formatter:on
    }

}
