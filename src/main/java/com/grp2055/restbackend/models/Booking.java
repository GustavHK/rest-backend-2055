package com.grp2055.restbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking extends BaseEntity{

    int userId;
    int timeblock;
    int roomId;
    // Ved ikke helt hvordan date skal laves endnu

    protected Booking(){
    super(); // Henter id fra baeentity
    }

    public Booking (int userId, int timeblock, int roomId){
        this(); // Henter id fra Booking() uden argumenter, hvis klassen instantieres her fra.
        this.userId = userId;
        this.timeblock = timeblock;
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTimeblock() {
        return timeblock;
    }

    public void setTimeblock(int timeblock) {
        this.timeblock = timeblock;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
