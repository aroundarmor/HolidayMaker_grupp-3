package com.newton.holidaymaker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;






@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;


	public List<Room> findAll(){
		List<Room> room = new ArrayList<>();
		roomRepository.findAll().forEach(room::add);
		return room;
	}



	public Room getRoomById(Integer id) {
		if(roomRepository.existsById(id)){
			return roomRepository.findById(id).get();
		}
		return null;

	}



	public Room addRoom(Room room){
		return roomRepository.save(room);
	}
	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}




	public void deleteRoom(Integer id) {
		roomRepository.deleteById(id);

	}
}
