package com.grp2055.restbackend.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name="room")
public class Room extends BaseEntity {


    @Column(name = "size")
    private int size;

    protected Room() {
        super(); // Henter id fra baseentity
    }

    @ElementCollection()
    @CollectionTable(name="booking", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name="id")
    private Set<Integer> bookingList = new HashSet<>();

    public Room(int size) {
        this(); // Henter id fra Room() uden argumenter, hvis klassen instantieres her fra.
        this.size = size;
    }
}
