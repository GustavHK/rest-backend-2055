package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.config.AuthenticationDetails;
import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.service.BookingService;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookingController.URL)
public class BookingController {
    public static final String URL = "/bookings";
    private final BookingService bookingService;
    AuthenticationDetails details;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
        details = new AuthenticationDetails();
    }

    //GET
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

    @GetMapping("/room/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getAllRoomBookings(@PathVariable int id){
        return bookingService.findRoomBookings(id);
    }

    @GetMapping("/room/{id}/upcoming")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getRoomsUpcomingMeetings
            (@PathVariable int id){
        return bookingService.findUpcomingRoomBookings(id);
    }

    @GetMapping("/findByDate/{day}/{month}/{year}") // der skal år på
    @ResponseStatus(HttpStatus.OK)
    List<Booking> findBookingsByDate (@PathVariable int day,@PathVariable int month, @PathVariable int year){
        return bookingService.findBookingByDate(day,month,year);
    }

    @GetMapping("/user/{userid}")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserBookings(@PathVariable Integer userid){
        return  bookingService.findUserBookings(userid);
    }

    @GetMapping("/user/{userid}/upcoming")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserUpcomingMeetings
            (@PathVariable int userid){
        return bookingService.findUpcomingUserBookings(userid);
    }

    //Post
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public Booking createBooking(@RequestBody Booking booking)
    {

        booking.setUsername(details.getUserName());
        booking.setUserid(bookingService.getUserId(details.getUserName()));
        return bookingService.saveBooking(booking);
    }

    //PUT
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public Booking editBooking(@RequestBody Booking booking){
        return bookingService.editBooking(booking);
    }

    //DELETE

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
    }









}
