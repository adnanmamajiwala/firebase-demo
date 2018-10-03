package com.sample.firebase.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.vavr.control.Try;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FirebaseAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
        System.out.println("Inside authenticate ");
        Try.of(() -> objectWriter.writeValueAsString(authentication))
                .onSuccess(System.out::println);
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        if (!authentication.getPrincipal().equals("admin@hello.com") && authenticationToken.isAuthenticated()) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken("admin@hello.com", "Pass123", getAuthorities());
    }

    private List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ADMIN"));
        return grantedAuthorityList;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        System.out.println("Inside supports " + aClass.getName());
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
