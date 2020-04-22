package com.grp2055.restbackend.domain;

import com.grp2055.restbackend.repositories.BookingRepo;
import com.grp2055.restbackend.repositories.UserRepo;
import com.grp2055.restbackend.service.RoomService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import javax.jws.Oneway;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
