package com.newton.holidaymaker.controllers;

import com.newton.holidaymaker.models.Hotel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.RoomRepository;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    @GetMapping("/rooms/hotelid/{hotelId}")
    public List<Room> getRoomsByHotelId(@PathVariable int hotelId) {
        List<Room> rooms = roomRepository.getRoomsByHotelId(hotelId);
        return rooms;
    }
    @GetMapping("/rooms/roomtype/{roomType}")
    public List<Room> getRoomsByRoomType(@PathVariable String roomType) {
        List<Room> rooms = roomRepository.getRoomsByRoomType(roomType);
        return rooms;
    }
    @GetMapping("/rooms/isbooked/{isBooked}")
    public List<Room> getRoomsByIsBooked(@PathVariable Boolean isBooked) {
        List<Room> rooms = roomRepository.getRoomsByIsBooked(isBooked.equals(true));
        return rooms;
    }
}
