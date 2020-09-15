package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
