package com.newton.holidaymaker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class MainController {

    @GetMapping("/process")
    public String process(){
        return "FOUND";
    }

    

    
}
