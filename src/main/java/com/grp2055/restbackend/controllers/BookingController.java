package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @GetMapping("/user/{id}/upcoming")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserUpcomingMeetings
            (@PathVariable int id){
        List<Booking> allBookings = bookingService.findUserBookings(id);
        List<Booking> upcoming = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("TID HALLO" +now);
        int year = now.getYear();
        int month = now.getMonth().getValue();
        int day = now.getDayOfMonth();
        for (int i = 0; i < allBookings.size(); i++) {
            Booking booking = allBookings.get(i);
            System.out.println(booking.getYear()+" " +booking.getMonth()+" " +booking.getDay());
            if (booking.getYear() > year){
                upcoming.add(booking);
            } else if (booking.getYear() == year && booking.getMonth() > month) {
                upcoming.add(booking);
            }
            else if( booking.getYear() == year && booking.getMonth() == month && booking.getDay() >= day){
                upcoming.add(booking);
            }
        }
        return upcoming;
    }

    @GetMapping("/user/{id}/")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getallUserBookings
            (@PathVariable int id){
        return  bookingService.findUserBookings(id);





    }

}
