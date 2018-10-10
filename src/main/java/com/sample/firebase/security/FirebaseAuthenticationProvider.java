package com.sample.firebase.security;

import com.sample.firebase.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@Component
@RequiredArgsConstructor
public class FirebaseAuthenticationProvider implements AuthenticationProvider {

    private final FirebaseAuthenticationService firebaseAuthenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Inside authenticate ");

        if (isNull(authentication.getCredentials())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return validate(authentication);
    }

    private Authentication validate(Authentication authentication) {
        String token = (String) authentication.getCredentials();

        if (authentication.isAuthenticated()) {
            firebaseAuthenticationService.verifyToken(token);
            return authentication;
        } else {
            User user = firebaseAuthenticationService.retrieveUser(token);
            return new UsernamePasswordAuthenticationToken(user, token, getAuthorities());
        }
    }

    private List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ADMIN"));
        return grantedAuthorityList;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
