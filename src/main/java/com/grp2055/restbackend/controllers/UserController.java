package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(UserController.URL)
public class UserController {
    public static final String URL = "/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    /*
    @PostMapping("/{id}/addbooking") // måske forkert da man ikke kender det id man skal bruge?
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooking(@PathVariable int id, @RequestBody Booking booking){
        userService.findUserById(id).addBooking(booking.getId());
    }
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    boolean deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return true;
    }

}
