package com.newton.holidaymaker.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

//OBS måste kolla att datumobjektet fungerar med datumkolumnen i databasen/Hanna
//Kolumnerna för customer_id och room_id skulle varit bortkommaterade eftersom de skulle vara joinade med user respektive room. /*, insertable=false, updatable=false*/

@Entity
@Table (name = "booking")
public class Booking implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)                	private int bookingId;
    //@Column(name="room_id")                                               	private int roomId;
    @Column(name="customer_id", columnDefinition = "INT NOT NULL")        	    private int customerId;
    @Column(name="arrival_date", columnDefinition = "INT NOT NULL")   			private int arrivalDate;
    @Column(name="departure_date", columnDefinition = "INT NOT NULL") 			private int departureDate;
    @Column(name="extra_bed", columnDefinition = "BOOL NOT NULL")           	private boolean extraBed;
    @Column(name="two_meals", columnDefinition = "BOOL NOT NULL")           	private boolean twoMeals;
    @Column(name="three_meals", columnDefinition = "BOOL NOT NULL")         	private boolean threeMeals;
    @Column(name="all_inclusive", columnDefinition = "BOOL NOT NULL")       	private boolean allInclusive;

    /*@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private User user;*/
    
    @ManyToOne
    @JoinColumn(name="roomId", nullable=false)
    private Room room;

    public Booking() { }
    public Booking(int customerId, int date, int date2, boolean extraBed, boolean twoMeals, boolean threeMeals, boolean allInclusive)
    {
        this.customerId		= customerId;
    	this.arrivalDate    = date;
        this.departureDate  = date2;
        this.extraBed       = extraBed;
        this.twoMeals       = twoMeals;
        this.threeMeals     = threeMeals;
        this.allInclusive   = allInclusive;

    }

   	public int getId() {
        return bookingId;
    }

    public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(int arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(int departureDate) {
        this.departureDate = departureDate;
    }

    public boolean getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public Boolean getTwoMeals() {
        return twoMeals;
    }

    public void setTwoMeals(Boolean twoMeals) {
        this.twoMeals = twoMeals;
    }

    public Boolean getThreeMeals() {
        return threeMeals;
    }

    public void setThreeMeals(Boolean threeMeals) {
        this.threeMeals = threeMeals;
    }

    public Boolean getAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(Boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

}
