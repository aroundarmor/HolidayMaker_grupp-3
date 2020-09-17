package com.newton.holidaymaker.mockdata;

import java.util.Arrays;
import java.util.List;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInit implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) {

        User user1 = new User("Rafael", "Milanes", 1234, "ra@gmail.com", "Raf", encoder.encode("pass123"), "ADMIN", " HOTEL_WRITE, HOTEL_READ, BOOKING_READ, BOOKING_WRITE, USER_READ, USER_WRITE, ROOM_READ, ROOM_WRITE");
        User user2 = new User("John", "Smith", 1234, "johnny@gmail.com", "John", encoder.encode("pass1"), "USER", "HOTEL_READ");
        User user3 = new User("Ernest", "Hemingway", 3245, "ernest@gmail.com", "Ernest", encoder.encode("pass12"), "USER", "HOTEL_READ");

        List<User> users = Arrays.asList(user1, user2, user3);

        boolean nothingInhere = userRepository.findAll().isEmpty();

        if(nothingInhere){
            //Persist in DB
             userRepository.saveAll(users);
        }
    }
    
}
