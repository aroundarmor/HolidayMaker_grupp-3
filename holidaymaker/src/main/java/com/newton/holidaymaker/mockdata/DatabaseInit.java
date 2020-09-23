package com.newton.holidaymaker.mockdata;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.newton.holidaymaker.models.Booking;
import com.newton.holidaymaker.models.Hotel;
import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.BookingRepository;
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
    @Autowired private BookingRepository bookingRepository;
    @Autowired private BCryptPasswordEncoder encoder;

    public DatabaseInit(UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

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
            new User("Rafael",  "Milanes",   "1234", "ra@gmail.com",       "Raf",       encoder.encode("111"), "ADMIN","HOTEL_WRITE,HOTEL_READ,BOOKING_READ,BOOKING_WRITE,USER_READ,USER_WRITE,ROOM_READ,ROOM_WRITE"),
            new User("John",    "Smith",     "1234", "johnny@gmail.com",   "John",      encoder.encode("112"), "USER", "USER_READ"),
            new User("Ernest",  "Hemingway", "3245", "ernest@gmail.com",   "Ernest",    encoder.encode("113"), "USER", "USER_READ"),
            new User("Donald",  "Duck",      "1111", "donald@duck.com",    "donduck",   encoder.encode("120"), "USER", "USER_READ"),
            new User("Bugs",    "Bunny",     "1112", "bugs@bunny.com",     "bugsbunny", encoder.encode("121"), "USER", "USER_READ"),
            new User("Cookie",  "Monster",   "1113", "cookie@monster.com", "como1",     encoder.encode("122"), "USER", "USER_READ"),
            new User("Pepe",    "Greenfrog", "1113", "pepe@reee.com",      "pepe",      encoder.encode("123"), "USER", "USER_READ"),
            new User("Racecar", "McQueen",   "1114", "idk@mail.com",       "rcar",      encoder.encode("124"), "USER", "USER_READ")
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
        Hotel potato = new Hotel("Potato Hotel", "Sweden", "Mashedpotatoes 32");
        Hotel tomato = new Hotel("Tomato Hotel", "Sweden", "Rottentomato 531");
        Hotel cookie = new Hotel("Cookie Hotel", "Spain", "Cookiemonster 12");
        Hotel pasta  = new Hotel("Pasta Hotel", "Cuba", "Pastalavista 2");

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
    
    /**
    *
    * Generates sample booking - Linked to user 1 (if exists?) but no room as the code is now.
    *
    * */
    public void generateBookings() {
		List<Booking> bookings = Arrays.asList(
            new Booking(1, 20210713, 20210716, true, false, false, true),
            new Booking(1, 20210813, 20210814, true, false, false, true),
            new Booking(1, 20210701, 20210703, true, false, false, true),
            new Booking(1, 20210729, 20210730, true, false, false, true),
            new Booking(1, 20210805, 20210812, true, false, false, true)
        );

        if(bookingRepository.count() == 0)
            bookingRepository.saveAll(bookings);
    }


}
