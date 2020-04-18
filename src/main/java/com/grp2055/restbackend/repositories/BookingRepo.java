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

    @Override
    void deleteById(Integer id);

    @Query(
            value = "SELECT * FROM booking WHERE day = ? AND month = ?;",
            nativeQuery = true) // Skal der ikke år på?
    List<Booking> findBookingByDate(int day, int month);

    @Query(
            value = "SELECT * FROM booking  WHERE username = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n"+
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findUserUpcomingBookings(int userid);

    @Query(
            value = "SELECT * FROM booking  WHERE room_id = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n"+
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findRoomUpcomingBookings(int id);}

