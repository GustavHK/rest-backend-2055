package com.grp2055.restbackend.controllers;


import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping(UserController.URL)
public class UserController {
    static final String URL = "/users";

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
