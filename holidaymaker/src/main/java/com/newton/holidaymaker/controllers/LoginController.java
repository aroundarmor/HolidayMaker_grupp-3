package com.newton.holidaymaker.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView("login");
		String title = "HolidayMaker | Login";
		
		if(session.getAttribute("username") != null) {
			System.out.println("session is active");
			mv.setViewName("index");
			mv.addObject("title", "HolidayMaker | Welcome");
			mv.addObject("username", session.getAttribute("username"));
		}
		
		return mv;
	}
}
