package com.newton.holidaymaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired RoomRepository roomRepository;

    @GetMapping("/")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable Integer id){
    	  if(roomRepository.existsById(id)){
    	    	return roomRepository.findById(id).get();
    	        }
    	          return null;
        
    }
   
}
