package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.repositories.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking findBookingById(int id) {
        return bookingRepo.findById(id).get();
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public List<Booking> findUserBookings(int id) {
        return bookingRepo.findBookingsByuserId(id);
    }

    @Override
    public List<Booking> findUpcomingUserBookings(int id) {
        return bookingRepo.findUserUpcomingBookings(id);
    }

    @Override
    public List<Booking> findUpcomingRoomBookings(int id) {
        return bookingRepo.findRoomUpcomingBookings(id);
    }

    @Override
    public List<Booking> findRoomBookings(int id) {
        return bookingRepo.findBookingsByRoomId(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }



}
