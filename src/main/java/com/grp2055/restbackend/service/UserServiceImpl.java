package com.grp2055.restbackend.service;

import com.grp2055.restbackend.models.User;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User findBookingId(Long id) {
        return userRepo.findById(id).get();
    }
//Her
    @Override
    public User getAdminStatus(boolean isAdmin) {
        return userRepo.(isAdmin);
    }

}
