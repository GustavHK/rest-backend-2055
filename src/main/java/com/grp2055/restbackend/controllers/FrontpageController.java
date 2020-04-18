package com.grp2055.restbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class FrontpageController {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String frontPage(HttpServletRequest request, HttpServletResponse response){
        // https://stackoverflow.com/questions/17068442/how-to-get-the-full-requested-url-in-java
        // Kode til at hente hoved URL tagget, uanset hvis det er localhost eller på en server.

        String url = request.getRequestURL().toString();

        return "<p> Velkommen til vores REST-API for lokale booking. </p>" +
                "<p>Indtast en af følgende links for at navigere rundt.</p>"+
                "Brugere: <a href=\""+url+"users\">/users</a> <br>"+
                "Bookings: <a href=\""+url+"bookings\">/bookings</a> <br>"+
                "Lokaler: <a href=\""+url+"rooms\">/rooms</a>";
    }
}
