package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
