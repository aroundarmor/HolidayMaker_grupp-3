package com.newton.holidaymaker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Room {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int roomId;
	private String roomType;
	private double roomPrice;
	private int hotelId;
	private int bookingId;
	private boolean isBooked;

	public Room() {
	}

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

	
	
}

