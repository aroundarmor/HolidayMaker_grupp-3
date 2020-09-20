/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.holidaymaker.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ted
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)                         
        @Column(name = "hotelID")                                                       private int hotelId;
        @Column(name = "hotelName", columnDefinition = "VARCHAR(250) NOT NULL")         private String hotelName;
        @Column(name = "hotelCountry", columnDefinition = "VARCHAR(250) NOT NULL")      private String hotelCountry;
        @Column(name = "hotelAddress", columnDefinition = "VARCHAR(250) NOT NULL")      private String hotelAddress;
    
        @OneToMany
        @JoinColumn(name = "hotelId")
        private Set<Room> rooms;

        public Hotel() {}
        public Hotel(String hotelName, String hotelCountry, String hotelAddress) {
                this.hotelName = hotelName;
                this.hotelCountry = hotelCountry;
                this.hotelAddress = hotelAddress;
    }

        public int getHotelID() {return hotelId;}

        public String getHotelName()    {return hotelName;}
        public String getHotelCountry() {return hotelCountry;}
        public String getHotelAddress() {return hotelAddress;}

        public void setHotelName(String hotelName)       {this.hotelName = hotelName;}
        public void setHotelCountry(String hotelCountry) {this.hotelCountry = hotelCountry;}
        public void setHotelAddress(String hotelAddress) {this.hotelAddress = hotelAddress;}

}
