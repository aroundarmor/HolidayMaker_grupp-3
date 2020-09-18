package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends PageControllerEssentials implements PageControllerInterface {

    @GetMapping("/")
	public ModelAndView run(HttpServletRequest req, HttpServletResponse res, Principal principal) {
        ModelAndView mv = initModelAndView("HolidayMaker | Welcome", null, "main");

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
