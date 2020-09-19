package com.newton.holidaymaker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)                private int id;
/*    @Column(name="roomId")												    private int roomId;*/
    @Column(name="roomType")    											private String roomType;
    @Column(name="roomPrice")    											private double roomPrice;
    @Column(name="hotelId")     											private int hotelId;
    /*@Column(name="bookingId")   											private int bookingId;*/
    @Column(name="isBooked")            									private Boolean isBooked;

	public Room() { }
	public Room(Integer id,String roomType, double roomPrice, int hotelId, /*int bookingId, */ boolean isBooked) {
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.hotelId = hotelId;
		//this.bookingId = bookingId;
		this.isBooked = isBooked;
	}
	
	public void copy(Room r) {
		this.id = r.id;
		this.roomType = r.roomType;
		this.roomPrice = r.roomPrice;
		this.hotelId = r.hotelId;
		//this.bookingId = r.bookingId;
		this.isBooked = r.isBooked;
	}
	
/*
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
*/
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
/*
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
*/
	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public void getId() {
		this.id = id;
		// TODO Auto-generated method stub
		
	}
}
