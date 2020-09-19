package com.newton.holidaymaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.newton.holidaymaker.models.Booking;
import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;
import com.newton.holidaymaker.services.RoomService;

@RestController
@RequestMapping("/")
public class RoomController {
        
        @Autowired
        private RoomService roomService;
        
       
        @RequestMapping(method = RequestMethod.GET, value = "/all")
        public List<Room> findAll(){
            return roomService.findAll();
        }
        
       
        
        @RequestMapping(method = RequestMethod.GET, value = "/get-room/{id}")
        public Room getRoomById(@PathVariable Integer id){
            Room room = roomService.getRoomById(id);
            if (room != null){
            return roomService.getRoomById(id);
            }
            return null;
        }

       
        @RequestMapping(method = RequestMethod.POST, value = "/add-room")
        public Room addRoom(@RequestBody Room room){
               return roomService.addRoom(room);
           
        }
        
        
             
    
        
        
        	
        	
        
                
      
      
       
       

  	 
    

    
    
    
    	 
   
}
