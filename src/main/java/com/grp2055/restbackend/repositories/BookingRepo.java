package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingsByUserId(int id);
    List<Booking> findBookingsByRoomId(int id);



    @Query(
            value = "SELECT * FROM booking WHERE day = ? AND month = ?;",
            nativeQuery = true) // Skal der ikke år på?
    List<Booking> findBookingByDate(int day, int month);



    @Query(
            value = "SELECT * FROM booking  WHERE user_id = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n"+
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findUserUpcomingBookings(int id);


    @Query(
            value = "SELECT * FROM booking  WHERE room_id = ? AND  year >= YEAR(CURRENT_DATE) " +
                    "and month >= MONTH(CURRENT_DATE)\n" +
                    "and CASE WHEN month = MONTH(CURRENT_DATE) THEN day >= DAY(CURRENT_DATE)\n"+
                    "ELSE any_value(day) end",
            nativeQuery = true)
    List<Booking> findRoomUpcomingBookings(int id);}
