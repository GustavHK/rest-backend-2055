package com.grp2055.restbackend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
