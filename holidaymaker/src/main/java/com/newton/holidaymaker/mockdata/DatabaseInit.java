package com.newton.holidaymaker.mockdata;

import java.util.Arrays;
import java.util.List;

import com.newton.holidaymaker.models.Hotel;
import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.HotelRepository;
import com.newton.holidaymaker.repositories.RoomRepository;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInit implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private HotelRepository hotelRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        generateUsers();
        generateHotels();
    }

    /**
    *
    * Generates sample users
    *
    * */
    public void generateUsers() {
        List<User> users = Arrays.asList(
            new User("Rafael",  "Milanes",   1234, "ra@gmail.com",       "Raf",         encoder.encode("pass123")),
            new User("John",    "Smith",     1234, "johnny@gmail.com",   "John",        encoder.encode("pass1")),
            new User("Ernest",  "Hemingway", 3245, "ernest@gmail.com",   "Ernest",      encoder.encode("pass12")),
            new User("Donald",  "Duck",      1111, "donald@duck.com",    "donduck",     encoder.encode("120")),
            new User("Bugs",    "Bunny",     1112, "bugs@bunny.com",     "bugsbunny",   encoder.encode("121")),
            new User("Cookie",  "Monster",   1113, "cookie@monster.com", "como1",       encoder.encode("122")),
            new User("Pepe",    "Greenfrog", 1113, "pepe@reee.com",      "pepe",        encoder.encode("123")),
            new User("Racecar", "McQueen",   1114, "idk@mail.com",       "rcar",        encoder.encode("124"))
        );

        if(userRepository.count() == 0)
            userRepository.saveAll(users);
    }

    /**
    *
    * Generates sample hotels & rooms
    *
    * */
    public void generateHotels() {

        // ----------------
        // Generate Hotels
        // ----------------
        Hotel potato = new Hotel(1, "Potato Hotel", "Potato Country", "Mashedpotatoes 32");
        Hotel tomato = new Hotel(2, "Tomato Hotel", "Tomato Country", "Rottentomato 531");
        Hotel cookie = new Hotel(3, "Cookie Hotel", "Cookie Country", "Cookiemonster 12");
        Hotel pasta  = new Hotel(4, "Pasta Hotel", "Pasta Country", "Pastalavista 2");

        List<Hotel> hotels = Arrays.asList(potato, tomato, cookie, pasta);

        if(hotelRepository.count() == 0)
            hotelRepository.saveAll(hotels);

        // ---------------
        // Generate Rooms
        // ---------------

        // POTATO HOTEL ROOMS
        List<Room> potatoRooms = Arrays.asList(
            new Room("Single", 100d, potato.getHotelID(), false),
            new Room("Double", 125d, potato.getHotelID(), true),
            new Room("Triple", 150d, potato.getHotelID(), true),
            new Room("Quad",   175d, potato.getHotelID(), false),
            new Room("King",   200d, potato.getHotelID(), false),
            new Room("Queen",  250d, potato.getHotelID(), true)
        );

        // TOMATO HOTEL ROOMS
        List<Room> tomatoRooms = Arrays.asList(
            new Room("Single", 100d, tomato.getHotelID(), true),
            new Room("Double", 125d, tomato.getHotelID(), true),
            new Room("Triple", 150d, tomato.getHotelID(), false),
            new Room("Quad",   175d, tomato.getHotelID(), false),
            new Room("King",   200d, tomato.getHotelID(), false),
            new Room("Queen",  250d, tomato.getHotelID(), true)
        );

        // COOKIE HOTEL ROOMS
        List<Room> cookieRooms = Arrays.asList(
            new Room("Single", 100d, cookie.getHotelID(), true),
            new Room("Double", 125d, cookie.getHotelID(), true),
            new Room("Triple", 150d, cookie.getHotelID(), true),
            new Room("Quad",   175d, cookie.getHotelID(), true),
            new Room("King",   200d, cookie.getHotelID(), true),
            new Room("Queen",  250d, cookie.getHotelID(), true)
        );

        // PASTA HOTEL ROOMS
        List<Room> pastaRooms = Arrays.asList(
            new Room("Single", 100d, pasta.getHotelID(), true),
            new Room("Double", 125d, pasta.getHotelID(), false),
            new Room("Triple", 150d, pasta.getHotelID(), true),
            new Room("Quad",   175d, pasta.getHotelID(), false),
            new Room("King",   200d, pasta.getHotelID(), false),
            new Room("Queen",  250d, pasta.getHotelID(), false)
        );

        if(roomRepository.count() == 0) {
            roomRepository.saveAll(potatoRooms);
            roomRepository.saveAll(tomatoRooms);
            roomRepository.saveAll(cookieRooms);
            roomRepository.saveAll(pastaRooms);
        }
    }

}
