package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.domain.Booking;
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
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getAllBookings(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Booking getBookingById(@PathVariable int id){
        return bookingService.findBookingById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
    }



}
