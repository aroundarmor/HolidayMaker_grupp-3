# HolidayMaker_grupp-3
FullStack Application hotel management system. Newton project.


## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)


## General info
Holidaymakers should be a website where customers can book
holiday accommodation in a modern and simple way.
You can do complex searches for vacant accommodation based on several choices.
You can log in and book an accommodation, and see / change Already booked
accommodation.

## Screenshots
![Example screenshot](https://github.com/musicollins/HolidayMaker_grupp-3/issues/38#issue-707644003)

## Technologies
* Mysql 5.5
* Java  13
* Html, Css
* JavaScript, Jquery
* Springboot

## Setup
Describe how to install / setup your local environement / add link to demo version.

Run your project by using terminal or commandline:
cd ~/desktop
* $ mkdir folder
* $ cd folder
* $ git clone https://github.com/musicollins/HolidayMaker_grupp-3.git
* $ cd *HolidayMaker
* $ cd holidaymaker
* $ mvn spring-boot:run

Open your browser and type http://localhost:8091


## Code Examples
Example of some controllers:
```
@GetMapping("/bookings")
    public List<Booking> getBookings() {
        System.out.println("Bookings retrieved");
        return repository.findAll();
    }
  ```
  ```
   }
    @GetMapping("/hotels/id/{hotelId}")
    public List<Hotel> getById(@PathVariable int hotelId) {
        List<Hotel> hotels = repository.findByHotelId(hotelId);
        return hotels;
    }
  
  ```
  
  Example of mockdata:
  ```
   List<Room> cookieRooms = Arrays.asList(
            new Room("Single", 100d, cookie.getHotelID(), false),
            new Room("Double", 125d, cookie.getHotelID(), false),
            new Room("Triple", 150d, cookie.getHotelID(), false),
            new Room("Quad",   175d, cookie.getHotelID(), false),
            new Room("King",   200d, cookie.getHotelID(), false),
            new Room("Queen",  250d, cookie.getHotelID(), false)
        );
        
  ```
  
  
  
  

## Features
List of features ready and TODOs for future development
*  Booking feature
*  Change booking feature
*  Search filtration feature
*  Delete booking feature

## Status
Project is:  _finished_



