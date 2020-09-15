package com.newton.holidaymaker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Room {

@Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	    private int id;
	    
	    @Column(name="roomId", columnDefinition = "VARCHAR(250) NOT NULL")
	    private int roomId;
	    @Column(name="roomType", columnDefinition = "VARCHAR(250) NOT NULL")
	    private String roomType;
	    @Column(name="roomPrice", columnDefinition = "DOUBLE(250) NOT NULL")
	    private double roomPrice;
	      @Column(name="hotelId", columnDefinition = "VARCHAR(250) NOT NULL")
	    private int hotelId;
	   @Column(name="bookingId", columnDefinition = "VARCHAR(250) NOT NULL")
	    private int bookingId;
	    @Column(name="isBooked", columnDefinition = "BOOL NOT NULL")
	    private Boolean isBooked;


	public Room() { }
	public Room(String roomType, double roomPrice, int hotelId, int bookingId, boolean isBooked) {
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.hotelId = hotelId;
		this.bookingId = bookingId;
		this.isBooked = isBooked;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
<<<<<<< HEAD
=======

	
	//
>>>>>>> 8847359719db295f464c24e5d1f604bb1be0b681
}
