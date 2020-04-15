package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Booking;

import java.util.List;

public interface BookingService {
    Booking findBookingById(int id);
    List<Booking> findAllBookings();
    List<Booking> findUserBookings(int id);
    List<Booking> findUpcomingUserBookings(int id);
    List<Booking> findUpcomingRoomBookings(int id);
    List<Booking> findRoomBookings(int id);
    List<Booking> findBookingByDate(int day,int month);
    Booking saveBooking(Booking booking);
    Booking editBooking(Booking booking);
    void deleteBooking(int id);


}
