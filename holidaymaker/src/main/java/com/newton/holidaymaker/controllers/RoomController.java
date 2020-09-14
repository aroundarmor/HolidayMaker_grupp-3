package com.newton.holidaymaker.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.service.RoomService;

@RestController
public class RoomController {
	
@Autowired RoomService roomService;
	
	
	@RequestMapping("/rooms")
	public List <Room> getAllRooms() {
		return roomService.getAllRooms();
	}

		
}


//git problem