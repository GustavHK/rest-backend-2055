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
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
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

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getallUserBookings
            (@PathVariable int id){
        return  bookingService.findUserBookings(id);
    }

    @GetMapping("/user/{id}/upcoming")
    @ResponseStatus(HttpStatus.OK)
    List<Booking> getUserUpcomingMeetings
            (@PathVariable int id){
        return bookingService.findUpcomingUserBookings(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public Booking editBooking(@RequestBody Booking booking){
        return bookingService.editBooking(booking);

    }




}
