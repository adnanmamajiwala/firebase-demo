package com.sample.firebase.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigninController {

    @GetMapping("/login")
    public String login(){
        return "login/signin";
    }

//    @PostMapping("/login")
//    public String loginPost(){
//        return "redirect:/home";
//    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @PostMapping("/error")
    public String error(){
        return "index";

    }
}
