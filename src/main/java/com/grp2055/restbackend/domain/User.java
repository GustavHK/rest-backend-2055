package com.grp2055.restbackend.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class User extends BaseEntity {


    protected User() {
        super(); // Henter id fra baseentity
    }

    String firstName;
    String lastName;
    boolean isAdmin;

@ElementCollection
    private List<Long> bookingList;




    public User(boolean isAdmin, String firstName, String lastName) {
        this();
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void addBooking(Booking booking) {
        bookingList.add(booking.getId());
    }

    public void removeBooking(Long bookingId) { //Der skal muligvis implementeres noget til hvis der ikke er et møde med det id man vil slette.
        for (int i = 0; i < bookingList.size(); i++) {
            //  if (bookingList.get(i).getId() == bookingId){
            bookingList.remove(i);
            break;
        }
    }
}
