/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.Hotel;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ted
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	List<Hotel> findByHotelCountry(String hotelCountry);
	List<Hotel> findByHotelName(String hotelName);

	@Query(value="SELECT DISTINCT hotelCountry FROM Hotel")
	List<String> findAllCountries();
	List<Hotel> findByHotelId(int hotelId);
}
