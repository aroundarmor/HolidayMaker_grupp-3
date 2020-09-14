/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.repositories;

import com.newton.holidaymaker.models.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ted
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
