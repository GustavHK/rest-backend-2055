package com.grp2055.restbackend.controllers;


import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.rmi.Naming;
import java.util.List;

@RestController
@RequestMapping(UserController.URL)
public class UserController {
    public static final String URL = "/api/users";

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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //POST
    @PostMapping("/newuser")
    @ResponseStatus(HttpStatus.OK)
    public User createNewUser(@RequestBody User user){
        User returnUser = new User(user.getUsername(),user.getFirstName(),user.getLastName(), user.getPassword(),"ROLE_USER");
        return userService.createNewUser(returnUser);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean login (@RequestBody Login login) throws Exception {

        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        try {

            Bruger brugerLogin = ba.hentBruger(login.getUsername(), login.getPassword());

            if(userService.findUserByUsername(login.getUsername()) == null ){
                User user = new User();
                user.setUsername(login.getUsername());
                user.setPassword(login.getPassword());
                createNewUser(user);
            }
            return true;
        } catch (IllegalArgumentException e) {

            System.out.println(login.getPassword());
            System.out.println(login.getUsername());
            System.out.println("Login not authorized");
        }
        return false;
    }
    public static class Login{
        static String username;
        static String password;
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

    //POST
    @PermitAll
    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public User authenticate(@RequestBody String username, @RequestBody String password){
        if (userService.findUserByUsername(username) != null) {
            return userService.findUserByUsername(username);
        }
        else return null;
    }

    //PUT
    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED) // skal give anden responsestatus hvis den fejler med at create.
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    boolean deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return true;
    }




}
