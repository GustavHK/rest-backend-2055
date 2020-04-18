package com.grp2055.restbackend.service;

        import com.grp2055.restbackend.domain.Booking;

        import java.util.List;

public interface BookingService {
    Booking findBookingById(int bookingid);
    List<Booking> findAllBookings();
    List<Booking> findUserBookings(int userid);
    List<Booking> findUpcomingUserBookings(int userid);
    List<Booking> findUpcomingRoomBookings(int roomid);
    List<Booking> findRoomBookings(int roomid);
    List<Booking> findBookingByDate(int day,int month);
    Booking saveBooking(Booking booking);
    Booking editBooking(Booking booking);
    void deleteBooking(int id);


}
