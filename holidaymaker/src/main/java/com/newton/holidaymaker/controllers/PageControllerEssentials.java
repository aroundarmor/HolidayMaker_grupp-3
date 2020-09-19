package com.newton.holidaymaker.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class PageControllerEssentials {
    /**
    *   @param String title       - (REQUIRED)
    *   @param String cssFileName - (OPTIONAL) name of the css file which belongs to the specific page
    *   @param String viewName    - (REQUIRED) view to be rendered
    *
    *   @return the modified ModelAndView after setting necessary attributes.
    */
    public ModelAndView initModelAndView(String title, String pageCss, String viewName) {
        ModelAndView m = new ModelAndView();
        m.addObject("title", title);
        m.addObject("pageCss", (pageCss == null ? null:"/css/pages/"+pageCss+".css"));
        m.addObject("page", viewName);
        m.setViewName("index");
        return m;
    }

    /**
    *   @param location - the location where clients are redirected
    * */
    public void redirect(String location, HttpServletResponse res) {
        res.setHeader("location", location);
        res.setStatus(302);
    }
}
