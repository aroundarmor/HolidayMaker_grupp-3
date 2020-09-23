package com.newton.holidaymaker.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import com.newton.holidaymaker.dto.*;

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

    public List<UserBooking> rowMapUserBookings(List<Object[]> o) {
    	List<UserBooking> ub = new ArrayList<UserBooking>();

    	for(int i = 0; i < o.size(); i++) {		
    		UserBooking usrBooking = new UserBooking(
    				(String)(o.get(i)[0]),
    				(int)(o.get(i)[1]),
    				(int)(o.get(i)[2]),
    				(String)(o.get(i)[3]),
    				(Double)(o.get(i)[4]),
    				((BigInteger)o.get(i)[5]).longValue(),
    				((BigInteger)o.get(i)[6]).longValue(),
    				(boolean)(o.get(i)[7]),
    				(boolean)(o.get(i)[8]),
    				(boolean)(o.get(i)[9]),
    				(boolean)(o.get(i)[10])
            );

    		ub.add(usrBooking);
    	}

    	return ub;
    }
}
