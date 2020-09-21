package com.newton.holidaymaker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Room;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
    @Query("SELECT DISTINCT roomType FROM Room")
    List<String> findAllRoomTypes();
	List<Room> getRoomsByHotelId(int getRoomsByHotelId);
	List<Room> getRoomsByRoomType(String getRoomsByRoomType);
	List<Room> getRoomsByIsBooked(Boolean getRoomsByIsBooked);
	List<Room> findAllByOrderByRoomPriceAsc();
	List<Room> findAllByOrderByRoomPriceDesc();
	List<Room> findAllByIsBookedFalse();
	List<Room> findAllByIsBookedFalseOrderByRoomPriceAsc();
	List<Room> findAllByIsBookedFalseOrderByRoomPriceDesc();
	// List<Room> findAllByHotelsHotelIdOrderByRoomPriceAsc(int hotelId);
	List<Room> findAllByHotelsHotelNameOrderByRoomPriceAsc(String hotelName);
	List<Room> findAllByHotelsHotelNameOrderByRoomPriceDesc(String hotelName);
	
	// List<Room> findAllByHotelsHotelNameOrderByRoomPriceDesc_IsBookedFalse(String hotelName);


}
