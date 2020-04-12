package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;


@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingsByuserId(int id);
}
