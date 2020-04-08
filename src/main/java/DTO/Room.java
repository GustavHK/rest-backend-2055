package DTO;

import javax.validation.constraints.NotBlank;

public class Room {

    public Room(@NotBlank int roomId) {
        this.roomId = roomId;
    }

    @NotBlank
    int roomId;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
