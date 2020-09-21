package com.newton.holidaymaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	List<Room> findAllByIsBookedTrue();
	List<Room> findAllByIsBookedTrueOrderByRoomPriceAsc();
	List<Room> findAllByIsBookedTrueOrderByRoomPriceDesc();


}
//git problem