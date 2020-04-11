package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Room;

import java.util.List;

public interface RoomService  {
    Room findRoomById (Long Id);
    List<Room> findAllRooms();
    Room createNewRoom(Room room);
}
