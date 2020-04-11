package com.grp2055.restbackend.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name="user")
public class User extends BaseEntity {
    protected User() {
        super(); // Henter id fra baseentity
    }

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name="is_admin")
    boolean isAdmin = false;


    @ElementCollection()
    @CollectionTable(name="booking", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name="id")
    private Set<Integer> bookingList = new HashSet<>();


    public User(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addBooking(int id) {
        bookingList.add(id);
    }
}
