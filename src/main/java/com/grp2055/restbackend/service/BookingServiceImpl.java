package com.grp2055.restbackend.service;

import com.grp2055.restbackend.models.Booking;
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
    public Booking findBookingById(Long id) {
        return bookingRepo.findById(id).get();
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }
}
