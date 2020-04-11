package com.grp2055.restbackend.domain;


import javax.persistence.Entity;

@Entity
public class Room extends BaseEntity {

    private int size;

    protected Room (){
        super(); // Henter id fra baseentity
    }

    public Room(int size){
        this(); // Henter id fra Room() uden argumenter, hvis klassen instantieres her fra.
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
