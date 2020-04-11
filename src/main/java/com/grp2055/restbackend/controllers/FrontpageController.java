package com.grp2055.restbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FrontpageController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String frontPage(){
        return "<p> Velkommen til vores REST-API for lokale booking. </p>" +
                "<p>Indtast en af følgende links for at navigere rundt.</p>"+
                "Brugere: <a href=\"http://localhost:8080/users\">/users</a> <br>"+
                "Bookings: <a href=\"http://localhost:8080/bookings\">/bookings</a> <br>"+
                "Lokaler: <a href=\"http://localhost:8080/rooms\">/rooms</a>";
    }



}
