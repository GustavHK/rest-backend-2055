package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.domain.Room;

import java.util.Collection;
import java.util.List;

public interface BookingService {
    Booking findBookingById(int id);
    List<Booking> findAllBookings();
    List<Booking> findUserBookings(int id);
    List<Booking> findUpcomingUserBookings(int id);
    List<Booking> findUpcomingRoomBookings(int id);
    List<Booking>findRoomBookings(int id);
    Booking saveBooking(Booking booking);
    void deleteBooking(int id);


}
