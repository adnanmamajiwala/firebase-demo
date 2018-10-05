package com.sample.firebase.security;

import com.sample.firebase.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigninController {

    @GetMapping("/login")
    public String login(){
        return "login/signin";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/error")
    public String error(){
        return "index";

    }
}
