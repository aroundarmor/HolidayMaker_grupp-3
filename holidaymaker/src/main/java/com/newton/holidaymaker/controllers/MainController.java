package com.newton.holidaymaker.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping("/")
    public String homePage(){
        return "Welcome User: Home Page";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "Welcome Admin: Admin Page";
    }

    
        
}
