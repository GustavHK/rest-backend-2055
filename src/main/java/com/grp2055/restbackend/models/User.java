package com.grp2055.restbackend.models;


import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {


    protected User (){
        super(); // Henter id fra baseentity
    }

    int userId;
    int bookingId;
    boolean isAdmin;

    public User(boolean isAdmin, int userId) {
        this();
        this.isAdmin = isAdmin;
        this.userId = userId;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public boolean getAdminStatus() {
        return isAdmin;
    }

    public void setAdminStatus(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId= bookingId;
    }






}
