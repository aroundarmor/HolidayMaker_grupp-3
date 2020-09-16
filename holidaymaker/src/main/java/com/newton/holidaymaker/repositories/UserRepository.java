package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
	User findByUsername(String username);
	User findByEmail(String email);
}
