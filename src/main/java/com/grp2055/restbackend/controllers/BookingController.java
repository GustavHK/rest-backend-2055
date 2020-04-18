package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.service.BookingService;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/{day}/{month}")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> findFreeBookingByDate (@PathVariable int day,@PathVariable int month){
        return bookingService.findBookingByDate(day,month);
    }

    @GetMapping("/user/{userid}")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserBookings(@PathVariable Integer userid){
        System.out.println("Hej");
        return  bookingService.findUserBookings(userid);
    }

    @GetMapping("/user/{id}/upcoming")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserUpcomingMeetings
            (@PathVariable int userid){
        return bookingService.findUpcomingUserBookings(userid);
    }

    //Post
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public Booking createBooking(@RequestBody Booking booking){
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
    }








}
