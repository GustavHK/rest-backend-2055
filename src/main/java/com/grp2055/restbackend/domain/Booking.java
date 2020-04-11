package com.grp2055.restbackend.domain;

import javax.persistence.*;

@Entity
public class Booking extends BaseEntity{

    int timeblock;
    int roomId;
    // Ved ikke helt hvordan date skal laves endnu

    protected Booking(){
    super(); // Henter id fra baeentity
    }

    public Booking (int userId, int timeblock, int roomId){
        this(); // Henter id fra Booking() uden argumenter, hvis klassen instantieres her fra.
        this.timeblock = timeblock;
        this.roomId = roomId;
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
