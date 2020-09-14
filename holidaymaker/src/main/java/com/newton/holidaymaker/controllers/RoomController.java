package com.newton.holidaymaker.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;




@RestController
@Service
public class RoomController {
	
@Autowired RoomRepository roomRepository;
	
	

		
		
	
		
@GetMapping("/rooms")
public List<Room> getAllRooms(){
return roomRepository.findAll();

	
   
}




}
