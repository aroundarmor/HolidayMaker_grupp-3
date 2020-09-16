package com.newton.holidaymaker.controllers;

import java.util.List;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/auth")
public class AdministratorController {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @PostMapping("/admin/add")
    public String addUser(@RequestBody User user){
        String pass = user.getPassword();
        String encodedPass = encoder.encode(pass);
        user.setPassword(encodedPass);
        userRepo.save(user);

        return "User Added!";
    }

    @GetMapping("/admin/users")
    public List<User> users(){
        return userRepo.findAll();
    }
}
