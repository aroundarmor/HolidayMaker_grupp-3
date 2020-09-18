package com.newton.holidaymaker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView run(HttpServletRequest req, Authentication authentication){
        ModelAndView mv = new ModelAndView("index");


        // sample variable
        mv.addObject("title", "Holidaymaker | Welcome");
        mv.addObject("username", req.getSession().getAttribute("username"));

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        return mv;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }
}
