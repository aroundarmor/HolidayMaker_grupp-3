package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
