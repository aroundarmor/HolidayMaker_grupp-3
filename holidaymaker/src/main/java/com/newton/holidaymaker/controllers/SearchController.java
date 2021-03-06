package com.newton.holidaymaker.controllers;

import java.util.List;

import com.newton.holidaymaker.models.Hotel;
import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.HotelRepository;
import com.newton.holidaymaker.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    
    
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private RoomRepository roomRepo;
    
    @GetMapping("/{country}")
    public List<Hotel> findByCountry (@PathVariable String country){
        return hotelRepo.findByHotelCountry(country);
    }

    @GetMapping("/price-asc")
    public List<Room> findByPriceAsc(){
        return roomRepo.findAllByOrderByRoomPriceAsc();
    }
    @GetMapping("/price-desc")
    public List<Room> findByPriceDesc(){
        return roomRepo.findAllByOrderByRoomPriceDesc();
    }

    @GetMapping("/available")
    public List<Room> availableRooms(){
        return roomRepo.findAllByIsBookedFalse();
    }
    
    @GetMapping("/available/price-asc")
    public List<Room> availableRoomsByPriceAsc(){
        return roomRepo.findAllByIsBookedFalseOrderByRoomPriceAsc();
    }
    @GetMapping("/name/{hotelname}/price-asc")
    public List<Room> roomsByHotelNameAsc(@PathVariable String hotelname){
        return roomRepo.findAllByHotelsHotelNameOrderByRoomPriceAsc(hotelname);
    }
    @GetMapping("/name/{hotelname}/price-desc")
    public List<Room> roomsByHotelNameDesc(@PathVariable String hotelname){
        return roomRepo.findAllByHotelsHotelNameOrderByRoomPriceDesc(hotelname);
    }
    @GetMapping("/id/{hotelid}/price-asc")
    public List<Room> roomsByHotelIdAsc(@PathVariable int hotelid){
        return roomRepo.findAllByHotelsHotelIdOrderByRoomPriceAsc(hotelid);
    }
    @GetMapping("/id/{hotelid}/price-desc")
    public List<Room> roomsByHotelIdDesc(@PathVariable int hotelid){
        return roomRepo.findAllByHotelsHotelIdOrderByRoomPriceDesc(hotelid);
    }
    // @GetMapping("/available/{hotelname}/price-desc")
    // public List<Room> availableRoomsByHotelNameDesc(@PathVariable String hotelname){
    //     return roomRepo.findAllByHotelsHotelNameOrderByRoomPriceDesc_IsBookedFalse(hotelname);
    // }
    @GetMapping("/available/price-desc")
    public List<Room> availableRoomsByPriceDesc(){
        return roomRepo.findAllByIsBookedFalseOrderByRoomPriceDesc();
    }
    

}
