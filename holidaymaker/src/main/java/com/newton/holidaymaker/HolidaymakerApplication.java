package com.newton.holidaymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.newton.holidaymaker")
public class HolidaymakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidaymakerApplication.class, args);
	}

	

}
