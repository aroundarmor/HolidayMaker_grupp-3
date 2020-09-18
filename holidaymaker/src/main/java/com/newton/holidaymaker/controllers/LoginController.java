package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController extends PageControllerEssentials implements PageControllerInterface {

    @GetMapping("/login")
    @Override
    public ModelAndView run(HttpServletRequest req, HttpServletResponse res, Principal principal) {

        // Redirect already-logged-in users to index
        if(principal != null) {
            redirect("/", res);
            return null;
        }
        
        ModelAndView mv = initModelAndView("HolidayMaker | Login", null, "login");
        

        return mv;
    }
}
