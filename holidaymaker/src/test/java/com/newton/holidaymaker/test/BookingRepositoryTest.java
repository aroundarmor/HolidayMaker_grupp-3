package com.newton.holidaymaker.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.newton.holidaymaker.controllers.BookingController;
import com.newton.holidaymaker.repositories.BookingRepository;

@ExtendWith(MockitoExtension.class)
public class BookingRepositoryTest {

	@Mock
    private BookingRepository repository;
	
	@InjectMocks
    private BookingController bookingController;

    @BeforeEach
    void init() {

    }

    @Test
    void testGetBookings() {
        System.out.println("Test: /getBookings/");
    }

    @Test
    void testSaveBooking() {
        System.out.println("Test: /saveBookings/{id}");
    }

    @Test
    void testUpdateBooking() {
        System.out.println("Test: /updateBooking/{id}");
    }

    @Test
    void testDeleteBooking() {
        System.out.println("Test: /deleteBooking/{id}");
    }
}
