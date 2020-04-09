package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.models.Booking;
import com.grp2055.restbackend.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookingController.URL)
public class BookingController {
    public static final String URL = "/bookings";
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping()
    List<Booking> getAllBookings(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.findBookingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }



}