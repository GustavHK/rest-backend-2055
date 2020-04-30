package com.grp2055.restbackend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="booking")
public class Booking extends BaseEntity{

    @Column(name = "timeblock")
    int timeblock;

    @Column(name = "room_id")
    int roomId;

    @Column(name= "user_id")
    int userid;


    @Column(name ="username")
    String username;

    @Column(name="month")
    int month;

    @Column(name="year")
    int year;

    @Column(name="day")
    int day;


    protected Booking(){
        super(); // Henter id fra baeentity
    }

    public Booking (int userid){


        this(); // Henter id fra Booking() uden argumenter, hvis klassen instantieres her fra.
        this.userid = userid;


    }

}
