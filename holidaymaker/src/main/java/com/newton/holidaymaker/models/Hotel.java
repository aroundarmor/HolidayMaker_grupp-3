/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ted
 */
@Entity
public class Hotel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int hotelID;
    private String hotelName;
    private String hotelCountry;
    private String hotelAddress;

    public Hotel(int hotelID, String hotelName, String hotelCountry, String hotelAddress) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelCountry = hotelCountry;
        this.hotelAddress = hotelAddress;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

}
