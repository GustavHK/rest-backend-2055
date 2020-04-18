package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.repositories.BookingRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
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
        return bookingRepo.findBookingsByUserId(id);
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
    public List<Booking> findBookingByDate(int day, int month) {
        return bookingRepo.findBookingByDate(day,month);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public Booking saveBooking(Booking booking) {
        if (bookingRepo.existsById(booking.getId())){
            System.out.println("Booking with same id already exist");
            return null;
        }
        else { return bookingRepo.save(booking); }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public Booking editBooking(Booking booking) {
        if (bookingRepo.existsById(booking.getId())){
            return bookingRepo.save(booking);
        }
        else
            {
                System.out.println("No booking with this id exist");
                return null;
        }
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }
}
