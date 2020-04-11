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
    public void frontPage(){
        System.out.println("Nothing here");
    }



}
