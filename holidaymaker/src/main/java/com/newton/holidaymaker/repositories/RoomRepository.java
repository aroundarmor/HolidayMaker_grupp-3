package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newton.holidaymaker.models.Room;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	List<Room> getRoomsByHotelId(int getRoomsByHotelId);
	List<Room> getRoomsByRoomType(String getRoomsByRoomType);
	List<Room> getRoomsByIsBooked(Boolean getRoomsByIsBooked);

}
//git problem