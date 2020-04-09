package com.grp2055.restbackend.service;

import com.grp2055.restbackend.models.Booking;

import java.util.List;

public interface BookingService {
    Booking findBookingById(Long id);
    List<Booking> findAllBookings();
    Booking saveBooking(Booking booking);
}
