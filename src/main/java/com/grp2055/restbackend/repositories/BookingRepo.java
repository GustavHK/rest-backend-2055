package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingsByUserid(int userid);
    List<Booking> findBookingsByRoomId(int id);

    @Query (
            value = "SELECT id from user WHERE username = ?", nativeQuery = true)
    int findBookingUserId(String username);

    @Query(
            value = "SELECT * FROM booking WHERE day = ? AND month = ? AND YEAR = ?;",
            nativeQuery = true)
          List<Booking> findBookingByDate(int day, int month, int year);

    @Query(
            value = "SELECT * FROM booking  WHERE user_id = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n" +
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findUserUpcomingBookings(int userid);

    @Query(
            value = "SELECT * FROM booking  WHERE room_id = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n" +
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findRoomUpcomingBookings(int id);


    //Tjekker om brugeren der deleter enten er owneren af bookingen eller en admin, ellers kan man ikke slette
    @PreAuthorize("@bookingRepo.getOne(#id).username.equals(authentication.name) or hasRole('ROLE_ADIMN')")
    void deleteBookingById(@Param("id") int id);
}
