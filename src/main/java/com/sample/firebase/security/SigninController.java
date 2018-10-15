package com.sample.firebase.security;

import com.sample.firebase.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SigninController {

    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @ModelAttribute("user")
    public User getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (User) authentication.getPrincipal();
    }

}
