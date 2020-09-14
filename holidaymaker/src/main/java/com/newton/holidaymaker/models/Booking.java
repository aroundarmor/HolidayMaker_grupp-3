package com.newton.holidaymaker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;
    private int room_id;
    private int customer_id;
    private String arrival_date;
    private String departure_date;
    private boolean extra_bed;
    private boolean breakfast;
    private boolean two_meals;
    private boolean three_meals;
    private boolean all_included;
    
    
    public Booking (){}

    public Booking(int room_id, int customer_id, String arrival_date, String departure_date, boolean extra_bed,
            boolean breakfast, boolean two_meals, boolean three_meals, boolean all_included) {
        this.room_id = room_id;
        this.customer_id = customer_id;
        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.extra_bed = extra_bed;
        this.breakfast = breakfast;
        this.two_meals = two_meals;
        this.three_meals = three_meals;
        this.all_included = all_included;
    }
    

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
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

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public boolean isExtra_bed() {
        return extra_bed;
    }

    public void setExtra_bed(boolean extra_bed) {
        this.extra_bed = extra_bed;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isTwo_meals() {
        return two_meals;
    }

    public void setTwo_meals(boolean two_meals) {
        this.two_meals = two_meals;
    }

    public boolean isThree_meals() {
        return three_meals;
    }

    public void setThree_meals(boolean three_meals) {
        this.three_meals = three_meals;
    }

    public boolean isAll_included() {
        return all_included;
    }

    public void setAll_included(boolean all_included) {
        this.all_included = all_included;
    }


    

}
