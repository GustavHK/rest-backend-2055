package com.grp2055.restbackend.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    public Room(int size) {
        this(); // Henter id fra Room() uden argumenter, hvis klassen instantieres her fra.
        this.size = size;
    }
}
