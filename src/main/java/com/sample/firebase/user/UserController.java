package com.sample.firebase.user;

import com.sample.firebase.user.User;
import com.sample.firebase.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/hello/{name}")
    public Mono<User> getUser(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

}
