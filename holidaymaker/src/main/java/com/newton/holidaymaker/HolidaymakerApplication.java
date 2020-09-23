package com.newton.holidaymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.newton.holidaymaker")
@EntityScan(basePackages = {"com.newton.holidaymaker.models","com.newton.holidaymaker.dto"})
public class HolidaymakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidaymakerApplication.class, args);
	}

	

}
