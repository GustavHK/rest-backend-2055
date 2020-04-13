package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Room;

import java.util.List;

public interface RoomService  {
    Room findRoomById (int Id);
    List<Room> findAllRooms();
    Room createNewRoom(Room room);

    List<Room> findBySizeGreaterThan(int Size);
    List<Room> findBySizeLessThan(int Size);
    boolean deleteRoom(int id);
}

