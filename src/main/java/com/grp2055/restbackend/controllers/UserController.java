package com.grp2055.restbackend.controllers;


import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.models.ChangePassword;
import com.grp2055.restbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

@RestController
@RequestMapping(UserController.URL)
public class UserController {
    public static final String URL = "/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //POST
    @PostMapping("/newuser")
    @ResponseStatus(HttpStatus.OK)
    public User createNewUser(@RequestBody User user) throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        Bruger bruger = ba.hentBruger(user.getUsername(),user.getPassword());
        User returnUser = new User(user.getUsername(),bruger.fornavn,bruger.efternavn, user.getPassword(),"ROLE_USER", bruger.campusnetId);
        return userService.createNewUser(returnUser);
    }



    @PutMapping("/newpassword")
    @ResponseStatus(HttpStatus.OK)
    public boolean changePassword(@RequestBody ChangePassword authdata) throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");


        System.out.println(authdata.getUsername() + ": " + authdata.getCurrentPassword() + ": "+authdata.getNewPassword());

        try {
            ba.ændrAdgangskode(authdata.getUsername(),authdata.getCurrentPassword(), authdata.getNewPassword());
            User user = userService.findUserByUsername(authdata.getUsername());
            user.setPassword(authdata.getNewPassword());
            userService.editUser(user);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return false;
        }
    }


    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    boolean deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return true;
    }




}
