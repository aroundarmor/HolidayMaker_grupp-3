package com.newton.holidaymaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newton.holidaymaker.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	List<Booking> findAllByCustomerId(int customerId);

    @Query(value="SELECT "+
    "hotel.hotel_name as hotelName, "+
    "hotel.hotelid as hotelId, "+
    "room.room_id as roomId, "+
    "room.room_type as roomType, "+ 
    "room.room_price as roomPrice, "+

    "booking.arrival_date as arrivalDate, "+
    "booking.departure_date as departureDate, "+
    "booking.extra_bed as extraBed, "+
    "booking.two_meals as twoMeals, "+
    "booking.three_meals as threeMeals, "+
    "booking.all_inclusive as allInclusive "+

    "FROM room "+
    "LEFT JOIN hotel "+
      "ON room.hotel_id = hotel.hotelid "+
    "LEFT JOIN booking "+
      "ON booking.room_id = room.room_id "+
    "WHERE customer_id = :customer", nativeQuery = true)
    List<Object[]> getUserBookingsByCustomerId(@Param("customer") int customerId);
    
    @Modifying
    @Transactional
    @Query(value="DELETE FROM booking WHERE room_id = :roomId", nativeQuery = true)
    int deleteBookingRoom(@Param("roomId") int roomId);
}
