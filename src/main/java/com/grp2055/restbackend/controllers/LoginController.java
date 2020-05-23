package com.grp2055.restbackend.controllers;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import com.grp2055.restbackend.models.Login;
import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


@RestController
@RequestMapping(LoginController.URL)
public class LoginController {
    static final String URL = "/login";

    private final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean login(@RequestBody Login login) throws RemoteException, NotBoundException, MalformedURLException {

        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        //Tjekker om bruger eksisterer i brugerautorisationsmodulet, hvis det gør skal vores system logge ind lige meget hvad
        try { Bruger brugerLogin = ba.hentBruger(login.getUsername(), login.getPassword());

            if(userService.findUserByUsername(login.getUsername()) == null ){
                User user = new User();
                user.setUsername(login.getUsername());
                user.setPassword(login.getPassword());
                user.setFirstName(brugerLogin.fornavn);
                user.setLastName(brugerLogin.efternavn);
                user.setCampusId(brugerLogin.campusnetId);
                user.setRole("ROLE_USER");
                userService.createNewUser(user);
                return true;
            }
            // opdaterer passwordet i vores database hver gang man logger ind, for at sikre at vores password
            // er det samme som i brugerautorisation
            else {
                User user = userService.findUserByUsername(login.getUsername());
                user.setPassword(login.getPassword());
                userService.editUser(user);
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(login.getPassword());
            System.out.println(login.getUsername());
            System.out.println("Login not authorized");
            return false;
        }
        //  System.out.println(login.getPassword() + login.getUsername())
    }
}

