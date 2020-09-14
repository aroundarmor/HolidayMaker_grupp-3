package com.newton.holidaymaker.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

//OBS måste kolla att datumobjektet fungerar med datumkolumnen i databasen/Hanna

@Entity
public class Booking implements Serializable {

	    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) 
	    private int id;
	    @Column(name="room_id", columnDefinition = "VARCHAR(250) NOT NULL")
	    private int room_id;
	    @Column(name="customer_id", columnDefinition = "VARCHAR(250) NOT NULL")
	    private int customer_id;
	    @Column(name="arrival_date", columnDefinition = "DATE NOT NULL")
	    private Date arrival_date;
	    @Column(name="departure_date", columnDefinition = "DATE NOT NULL")
	    private Date departure_date;
	    @Column(name="extra_bed", columnDefinition = "BOOL NOT NULL")
	    private boolean extra_bed;
	    @Column(name="two_meals", columnDefinition = "BOOL NOT NULL")
	    private Boolean two_meals;
	    @Column(name="three_meals", columnDefinition = "BOOL NOT NULL")
	    private Boolean three_meals;
	    @Column(name="all_inclusive", columnDefinition = "BOOL NOT NULL")
	    private Boolean all_inclusive;
	   
//	    Constructors
	    public Booking() { }
	    
	    public Booking(int room, int customer, Date arrDate, Date depDate, Boolean bed, Boolean twoM, Boolean threeM, Boolean allIn)
	    {
	    	this.room_id = room;
	    	this.customer_id = customer;
	    	this.arrival_date = arrDate;
	    	this.departure_date = depDate;
	    	this.extra_bed = bed;
	    	this.two_meals = twoM;
	    	this.three_meals = threeM;
	    	this.all_inclusive = allIn;	       
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getRoom_id() {
			return room_id;
		}

		public void setRoom_id(int room_id) {
			this.room_id = room_id;
		}

		public int getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}

		public Date getArrival_date() {
			return arrival_date;
		}

		public void setArrival_date(Date arrival_date) {
			this.arrival_date = arrival_date;
		}

		public Date getDeparture_date() {
			return departure_date;
		}

		public void setDeparture_date(Date departure_date) {
			this.departure_date = departure_date;
		}

		public boolean getExtra_bed() {
			return extra_bed;
		}

		public void setExtra_bed(boolean extra_bed) {
			this.extra_bed = extra_bed;
		}

		public Boolean getTwo_meals() {
			return two_meals;
		}

		public void setTwo_meals(Boolean two_meals) {
			this.two_meals = two_meals;
		}

		public Boolean getThree_meals() {
			return three_meals;
		}

		public void setThree_meals(Boolean three_meals) {
			this.three_meals = three_meals;
		}

		public Boolean getAll_inclusive() {
			return all_inclusive;
		}

		public void setAll_inclusive(Boolean all_inclusive) {
			this.all_inclusive = all_inclusive;
		}
	    
	    
	    

}
