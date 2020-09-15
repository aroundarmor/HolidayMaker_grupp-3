package com.newton.holidaymaker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newton.holidaymaker.models.Booking;
import com.newton.holidaymaker.repositories.BookingRepository;

@RestController
public class BookingController {

    @Autowired
    private final BookingRepository repository;

    BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        System.out.println("Bookings retrieved");
        return repository.findAll();
    }

    @PostMapping("/bookings/post")
    public int saveBooking(@RequestBody Booking booking) {
        repository.save(booking);
        System.out.println("Person saved");
        return booking.getId();
    }

    @PutMapping("/bookings/put/{id}")
    public void updateBooking(@RequestBody Booking booking, @PathVariable(value = "id") Integer id) {
        Booking updateTarget = repository.getOne(id);
        updateTarget.setRoom_id(booking.getRoom_id());
        updateTarget.setCustomer_id(booking.getCustomer_id());
        updateTarget.setArrival_date(booking.getArrival_date());
        updateTarget.setDeparture_date(booking.getDeparture_date());
        updateTarget.setExtra_bed(booking.getExtra_bed());
        updateTarget.setTwo_meals(booking.getTwo_meals());
        updateTarget.setThree_meals(booking.getThree_meals());
        updateTarget.setAll_inclusive(booking.getAll_inclusive());
        repository.save(updateTarget);
        System.out.println("Booking updated");
    }

    @DeleteMapping("/bookings/delete/{id}")
    public void deleteBooking(@PathVariable(value = "id") Integer id) {
        repository.deleteById(id);
        System.out.println("Booking deleted");
    }

    //Ska returnera alla bookings för ett givet customer_id
    /*@GetMapping("/bookings/get/{customer_id}")
    public List<Booking> getBookingsByCustomer(@PathVariable(value = "customer_id") Integer id ){
    repository.findAll(id);
    }*/

}
