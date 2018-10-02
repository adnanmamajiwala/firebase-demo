package com.sample.firebase.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

    @GetMapping("/login1")
    public String login(){
        return "login/signin";
    }
}
