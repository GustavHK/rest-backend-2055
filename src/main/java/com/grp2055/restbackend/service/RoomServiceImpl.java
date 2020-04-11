package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Room;
import com.grp2055.restbackend.repositories.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final  RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public Room findRoomById(Long id) {
      return roomRepo.findById(id).get();
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room createNewRoom(Room room) {
        return roomRepo.save(room);
    }
}
