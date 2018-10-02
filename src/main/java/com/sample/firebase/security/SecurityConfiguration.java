package com.sample.firebase.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
//@EnableWebFluxSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                    .antMatchers("/vendor/**",  "/javascripts/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
//                        .failureForwardUrl("/login-auth")
                        .loginPage("/login1")
                        .permitAll()
                .and()
                    .logout()
                        .permitAll();
        // @formatter:on
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
//    }

    //    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.httpBasic().and()
                .csrf().disable()
                .authorizeExchange().anyExchange().permitAll()
                .and()
                .build();
    }

}
