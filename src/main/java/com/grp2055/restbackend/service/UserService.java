package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);
    List<User> findAllUsers();
    boolean deleteUser(int id);
    User createNewUser(User user);
}
