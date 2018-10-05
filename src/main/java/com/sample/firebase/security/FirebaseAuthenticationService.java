package com.sample.firebase.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.sample.firebase.user.User;
import com.sample.firebase.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FirebaseAuthenticationService {

    private final UserService userService;

    User retrieveUser(String token) {
        FirebaseToken firebaseToken = verifyIdToken(token);
        return userService.findByUuid(firebaseToken.getUid())
                .block();
    }

    void verifyToken(String token) {
        verifyIdToken(token);
    }

    private FirebaseToken verifyIdToken(String token) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (FirebaseAuthException e) {
            throw new BadCredentialsException(e.getErrorCode() + e.getMessage());
        }
    }
}
