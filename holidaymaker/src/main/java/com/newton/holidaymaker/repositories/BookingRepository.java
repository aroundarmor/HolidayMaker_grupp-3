package com.newton.holidaymaker.repositories;
import com.newton.holidaymaker.models.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository <Booking, Integer> {
    
}
