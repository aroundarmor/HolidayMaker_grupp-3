package com.newton.holidaymaker.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.holidaymaker.dto.UserBooking;
import com.newton.holidaymaker.models.Booking;
import com.newton.holidaymaker.models.Room;
import com.newton.holidaymaker.repositories.BookingRepository;
import com.newton.holidaymaker.repositories.RoomRepository;
import com.newton.holidaymaker.repositories.UserRepository;

@RestController
public class BookingController extends PageControllerEssentials {

    @Autowired
    private final BookingRepository repository;

    @Autowired
    RoomRepository roomRepo;

    @Autowired
    UserRepository userRepo;

    BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        System.out.println("Bookings retrieved");
        return repository.findAll();
    }
    @GetMapping("/bookings/{customerId}/allbookings")
    public List<Booking> getAllBookingsByUserId(@PathVariable int customerId){
        return repository.findAllByCustomerId(customerId);
    }

    @GetMapping("/bookings/{cid}")
    public List<Booking> getBookingsAsd(@PathVariable int cid) {
        return repository.findAllByCustomerId(cid);
    }

    @PostMapping("/bookings/post")
    public HashMap<String, String> saveBooking(@RequestBody Booking booking, Principal principal) {
    	HashMap<String, String> response = new HashMap<String, String>();

    	// user must be logged in
    	if(principal == null) {
    		response.put("message", "invalidSession");
    		return response;
    	}

    	int customerId = userRepo.findByUsername(principal.getName()).getCustomerId();
    	booking.setCustomerId(customerId);
        repository.save(booking);

        // update room status 'isBooked' to true
        Room room = roomRepo.findByRoomId(booking.getRoomId());
        room.setBooked(true);
        roomRepo.save(room);

        response.put("message", "success");
        return response;
    }

    @PutMapping("/bookings/put/{id}")
    public void updateBooking(@RequestBody Booking booking, @PathVariable(value = "id") Integer id) {
        Booking updateTarget = repository.getOne(id);
        //updateTarget.setRoomId(booking.getRoomId());
        updateTarget.setCustomerId(booking.getCustomerId());
        updateTarget.setArrivalDate(booking.getArrivalDate());
        updateTarget.setDepartureDate(booking.getDepartureDate());
        updateTarget.setExtraBed(booking.getExtraBed());
        updateTarget.setTwoMeals(booking.getTwoMeals());
        updateTarget.setThreeMeals(booking.getThreeMeals());
        updateTarget.setAllInclusive(booking.getAllInclusive());
        repository.save(updateTarget);
        System.out.println("Booking updated");
    }

    @DeleteMapping("/bookings/remove/{id}")
    public boolean deleteBooking(@PathVariable(value = "id") Integer id) {

        repository.deleteBookingRoom(id);

        if(roomRepo.existsById(id) == true) {
            Room r = roomRepo.findByRoomId(id);
            r.setBooked(false);
            roomRepo.save(r);
        }

        return true;
    }

    @GetMapping("/bookings/getUserBookings")
    public List<UserBooking> asd(Principal p) {

    	if(p == null)
    		return null;

    	int customerId = userRepo.findByUsername(p.getName()).getCustomerId();
    	List<Object[]> objectList = repository.getUserBookingsByCustomerId(customerId);

    	return rowMapUserBookings(objectList);
    }

    //Implementera metod för att returnera alla bookings för ett givet customer_id
    /*@GetMapping("/bookings/get/{customer_id}")
    public List<Booking> getBookingsByCustomer(@PathVariable(value = "customer_id") Integer id ){
    repository.findAll(id);
    }*/

    // @DeleteMapping("/bookings/{id}/delete-all")
    // public String removeAllBookingsByCustomerId(@PathVariable(value="id") int id){
    //     // List<Booking> bookingsOfThisUser = repository.findAllByCustomerId(id);
    //     // System.out.println(Arrays.asList(bookingsOfThisUser));
    //     int result = repository.deleteAllByCustomerId(id);
    //     System.out.println(result);
        
    //     return "All bookings deleted";
    // }

    @DeleteMapping("/bookings/deleteall/{hotelid}")
    public boolean removeAllBookingsByCustomerIdAndByHotelId(@PathVariable("hotelid") int hotelId, Principal p){

        if(p == null){
         return false;
        }    

        int customerId = userRepo.findByUsername(p.getName()).getCustomerId();
        repository.deleteAllBookings(customerId, hotelId);
        
        return true;
    
    }

}
