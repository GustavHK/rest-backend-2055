package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Booking;

import java.util.List;

public interface BookingService {
    Booking findBookingById(int id);
    List<Booking> findAllBookings();
    List<Booking> findUserBookings(int id);
    Booking saveBooking(Booking booking);
    void deleteBooking(int id);
}
