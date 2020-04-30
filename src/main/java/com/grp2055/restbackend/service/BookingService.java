package com.grp2055.restbackend.service;

        import com.grp2055.restbackend.domain.Booking;
        import org.springframework.security.access.prepost.PreAuthorize;
        import org.springframework.web.bind.annotation.PathVariable;

        import java.io.Console;
        import java.util.List;

public interface BookingService {
    Booking findBookingById(int bookingid);
    List<Booking> findAllBookings();
    List<Booking> findUserBookings(int userid);
    List<Booking> findUpcomingUserBookings(int userid);
    int getUserId(String username);
    List<Booking> findUpcomingRoomBookings(int roomid);
    List<Booking> findRoomBookings(int roomid);
    List<Booking> findBookingByDate(int day,int month, int year);
    Booking saveBooking(Booking booking);
    Booking editBooking(Booking booking);
    List<Booking> findUpcomingBookingsByFloor(int floor);
    List<Booking> findBookingsByDateAndFloor(int floor,int year,int month, int day);
    void deleteBooking(int id);


}
