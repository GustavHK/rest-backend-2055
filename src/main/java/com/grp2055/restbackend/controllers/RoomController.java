package com.grp2055.restbackend.controllers;

import com.grp2055.restbackend.domain.Room;
import com.grp2055.restbackend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RoomController.URL)
public class RoomController {
    public static final String URL = "/rooms";
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Room> getAllRooms(){
        return roomService.findAllRooms();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Room findRoomById(@PathVariable Long id){
        return roomService.findRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Room createNewRoom(Room room){
        return roomService.createNewRoom(room);
    }

}
