package com.newton.holidaymaker.controller;

import java.util.List;
import java.util.Set;

import com.newton.holidaymaker.models.Role;
import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/user")
    public Set<Role> user(){
        return userRepository.findAll().get(1).getRoles();
    }
    

    
}
