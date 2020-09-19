package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

        ModelAndView mv = initModelAndView("HolidayMaker | Login", "login", "login");
        return mv;
    }
    
    /**
    *
    * Handles logout requests.<br>
    * Active sessions are invalidated and the client is redirected to main page.
    *
    */
    @PostMapping("/logout")
    @ResponseBody
    public void logoutUser(HttpServletRequest req, HttpServletResponse res) {
    	System.out.println("res status: " + res.getStatus());
        HttpSession session = req.getSession();
        if(session.getAttribute("username") != null)
            session.invalidate();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) { 
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        
        redirect("/", res);    
    }
}
