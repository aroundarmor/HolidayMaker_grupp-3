package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Room;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
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
	List<Room> findAllByHotelsHotelIdOrderByRoomPriceAsc(int hotelid);
	List<Room> findAllByHotelsHotelIdOrderByRoomPriceDesc(int hotelid);
	// List<Room> findAllByHotelsHotelNameOrderByRoomPriceDesc_IsBookedFalse(String hotelName);


}
//git problem