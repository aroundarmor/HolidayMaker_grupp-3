package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.newton.holidaymaker.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
