package com.newton.holidaymaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    

    @GetMapping("/")
    public String home(){
        return "Welcome User: You are not logged in";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin: You're logged in";
    }
    @GetMapping("/customer")
    public String customer(){
        return "Welcome Customer: You're logged in";
    }
}
