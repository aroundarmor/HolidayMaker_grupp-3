/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ted
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    /*	boolean existsById(String hotelId);
    	boolean existsByName(String hotelName);
	boolean existsByCountry(String hotelCountry);
	boolean existsByAddress(String hotelAddress);
	
    	Hotel findById(String hotelId);
	Hotel findByName(String hotelName);
	Hotel findByCountry(String hotelCountry);
	Hotel findByAddress(String hotelAddress);
   */
}
