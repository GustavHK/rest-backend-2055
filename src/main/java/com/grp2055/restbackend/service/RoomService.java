package com.grp2055.restbackend.service;

import com.grp2055.restbackend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomService  {
    Room findRoomById (Long Id);
    List<Room> findAllRooms();
    Room createNewRoom(Room room);
}
