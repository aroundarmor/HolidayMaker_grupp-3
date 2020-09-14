package com.newton.holidaymaker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;







@Service
public class RoomService {
	
	@Autowired 
	RoomRepository roomRepository;

	private static final List<Room> ROOMS = new ArrayList<>(Arrays.asList(
			new Room("room1", 3, 3, 4, false),
			new Room("room2", 4, 3, 4, false)
			
			
//
			
			));
	public List<Room> getAllRooms()
	{
		
	    List<Room>ROOMS = new ArrayList<>();
	    roomRepository.findAll().forEach(ROOMS::add);
		return  ROOMS;
	}
		//
	
	
}
