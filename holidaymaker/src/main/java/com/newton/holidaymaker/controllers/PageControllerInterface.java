package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface PageControllerInterface {

    /**
    * Run method acts as main method for controllers which extend pageController
    */
	public abstract ModelAndView run(HttpServletRequest req, HttpServletResponse res, Principal principal);
}
