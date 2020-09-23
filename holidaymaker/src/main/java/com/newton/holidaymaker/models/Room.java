package com.newton.holidaymaker.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column(name="roomId")											private int roomId;
        @Column(name="roomType")                                        private String roomType;
        @Column(name="roomPrice")    				    				private double roomPrice;
        @Column(name="hotelId")     				    				private int hotelId;
        @Column(name="isBooked")            			    			private Boolean isBooked;
        /*@Column(name="bookingId")   				    				private int bookingId;*/
    
        @ManyToOne
        @JoinColumn(name = "hotelId", insertable = false, updatable = false)
        private Hotel hotels;

        // @OneToMany(mappedBy = "room")
        // private Set<Booking> roomBookings;
     
        public Room() { }
        public Room(String roomType, double roomPrice, int hotelId,/*int bookingId, */ boolean isBooked) {
                this.roomType = roomType;
                this.roomPrice = roomPrice;
                this.hotelId = hotelId;
                this.isBooked = isBooked;
             //this.bookingId = bookingId;
        }
        
        public Boolean getIsBooked(){return isBooked;}
        public Hotel getHotels() {return hotels;}
        public int getRoomId() {return roomId;}
        public String getRoomType() {return roomType;}
        public double getRoomPrice() {return roomPrice;}
        public int getHotelId() {return hotelId;}
        
        public void setRoomType(String roomType) {this.roomType = roomType;}
        public void setRoomPrice(double roomPrice) {this.roomPrice = roomPrice;}
        public void setHotelId(int hotelId) {this.hotelId = hotelId;}
        public boolean isBooked() {return isBooked;}
        public void setBooked(boolean isBooked) {this.isBooked = isBooked;}
/*
       public void setRoomId(int roomId) {this.roomId = roomId;}
        public int getBookingId() {return bookingId;
       public void setBookingId(int bookingId) {this.bookingId = bookingId;}*/
    
}