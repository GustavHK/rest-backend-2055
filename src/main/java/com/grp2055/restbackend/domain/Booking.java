package com.grp2055.restbackend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="booking")
@Embeddable
public class Booking extends BaseEntity{
    @Column(name = "timeblock")
    int timeblock;

    @Column(name = "room_id")
    int roomId;

    @Column(name="user_id")
    int userId;

    // Overvejer at lave en string til år måned og dag, så det bliver nemmere at søge i.
    @Column(name="date")
    String date;
    // Ved ikke helt hvordan date skal laves endnu

    protected Booking(){
    super(); // Henter id fra baeentity
    }


    public Booking (int userId){
        this(); // Henter id fra Booking() uden argumenter, hvis klassen instantieres her fra.
        this.userId = userId;
    }
}
