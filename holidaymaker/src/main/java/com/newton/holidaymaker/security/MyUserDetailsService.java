<<<<<<< Updated upstream:holidaymaker/src/main/java/com/newton/holidaymaker/security/MyUserDetailsService.java
package com.newton.holidaymaker.security;

import java.util.Optional;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);
    }
=======
// package com.newton.holidaymaker.services;

// import com.newton.holidaymaker.models.User;
// import com.newton.holidaymaker.repositories.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class MyUserDetailsService implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepo;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         User user = userRepo.findByUsername(username);
//         MyUserDetails userDetails = null;

//         if(user != null){
//             userDetails = new MyUserDetails();
//             userDetails.setUser(user);
//         }else{
//             throw new UsernameNotFoundException("User has not been found!");
//         }
        
//         return userDetails;
//     }
>>>>>>> Stashed changes:holidaymaker/src/main/java/com/newton/holidaymaker/services/MyUserDetailsService.java
    
// }
