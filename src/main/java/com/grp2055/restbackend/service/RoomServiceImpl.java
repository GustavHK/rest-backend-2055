package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.Room;
import com.grp2055.restbackend.repositories.RoomRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {
    private final  RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override

    public Room findRoomById(int id) {
      return roomRepo.findById(id).get();
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> findBySizeGreaterThan(int Size) {
        return roomRepo.findBySizeGreaterThanEqual(Size);
    }

    @Override
    public List<Room> findBySizeLessThan(int Size) {
        return roomRepo.findBySizeLessThanEqual(Size);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public boolean deleteRoom(int id) {
        roomRepo.deleteById(id);
        return true;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public Room editRoom(Room room) {
        if (roomRepo.existsById(room.getId())){
            return roomRepo.save(room);
        }
        else
        {
            System.out.println("No room with this id exist");
            return null;
        }
}
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public Room createNewRoom(Room room) {
        return roomRepo.save(room);
    }




}
