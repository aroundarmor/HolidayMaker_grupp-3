package com.newton.holidaymaker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView run(){
        ModelAndView mv = new ModelAndView("navbar");

        // sample variable
        mv.addObject("title", "Holidaymaker | Welcome");

        return mv;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }


}
