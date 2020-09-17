package com.newton.holidaymaker.controllers;

import java.util.List;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestRestApiController {
    
    private UserRepository userRepository;

    public TestRestApiController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/test")
    public String adminTest(){return "Admin Allowed here";}
    
    @GetMapping("/user/test")
    public String userTest(){return "User Allowed here";}

    @GetMapping("/allusers")
    public List<User> allUsers(){
        return userRepository.findAll();
    }

}
