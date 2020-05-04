package com.grp2055.restbackend.domain;

import javax.persistence.Column;



public class Login {

        @Column
        String username;

        @Column
        String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
