package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Long> {
}
