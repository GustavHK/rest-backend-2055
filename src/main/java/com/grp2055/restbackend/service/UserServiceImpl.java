package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findUserById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }


}
