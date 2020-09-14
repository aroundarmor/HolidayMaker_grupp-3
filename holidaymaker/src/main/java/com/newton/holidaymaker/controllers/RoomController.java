package com.newton.holidaymaker.controllers;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


