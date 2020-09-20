/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.controllers;

import com.newton.holidaymaker.models.Hotel;
import com.newton.holidaymaker.repositories.HotelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ted
 */
@RestController
public class HotelController {
    
    @Autowired
    private final HotelRepository repository;

    HotelController(HotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        System.out.println("Hotels received");
        return repository.findAll();
    }
    @GetMapping("/hotels/country/{country}")
    public List<Hotel> getByCountry(@PathVariable String country) {
        List<Hotel> hotels = repository.findByHotelCountry(country);
        return hotels;
    }
    @GetMapping("/hotels/name/{name}")
    public List<Hotel> getByName(@PathVariable String name) {
        List<Hotel> hotels = repository.findByHotelName(name);
        return hotels;
    }
    @GetMapping("/hotels/id/{hotelId}")
    public List<Hotel> getById(@PathVariable int hotelId) {
        List<Hotel> hotels = repository.findByHotelId(hotelId);
        return hotels;
    }
}
