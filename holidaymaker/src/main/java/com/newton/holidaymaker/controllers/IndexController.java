package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newton.holidaymaker.repositories.BookingRepository;
import com.newton.holidaymaker.repositories.HotelRepository;
import com.newton.holidaymaker.repositories.RoomRepository;

@Controller
public class IndexController extends PageControllerEssentials implements PageControllerInterface {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	RoomRepository roomRepository;

    @GetMapping("/")
    public ModelAndView run(HttpServletRequest req, HttpServletResponse res, Principal principal) {
        ModelAndView mv = initModelAndView("HolidayMaker | Welcome", null, "main");

        // Retrieve all country names form Hotel repo.
        // This will be used to display hotel-countries that are available in the database.
        mv.addObject("availableCountries", hotelRepository.findAllCountries());
        mv.addObject("availableRoomTypes", roomRepository.findAllRoomTypes());

        if(principal != null)
            mv.addObject("username", principal.getName());

        return mv;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }
}
