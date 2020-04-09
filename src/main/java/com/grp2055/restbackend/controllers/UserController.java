package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public static final String URL = "/user";


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Her
    @GetMapping
        boolean getAdminStatus() {
            return userService.find;
        }


}
