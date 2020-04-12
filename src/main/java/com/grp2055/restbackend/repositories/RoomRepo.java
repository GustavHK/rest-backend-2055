package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    List<Room> findBySizeGreaterThan(int Size);
}


