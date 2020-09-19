package com.newton.holidaymaker.services;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);

        MyUserDetails userDetails = new MyUserDetails(user);

        //IMPLEMENT VALIDATION
        // if(user != null){
        //     userDetails = new MyUserDetails();
        //     userDetails.setUser(user);
        // }else{
        //     throw new UsernameNotFoundException("User has not been found!");
        // }
        
        return userDetails;
    }
    
}
