package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
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

    @Override
    public boolean deleteUser(int id) {
        userRepo.deleteById(id);
        return true;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public User createNewUser(User user) {
      return userRepo.save(user);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
    public User editUser(User user) {
        if (userRepo.existsById(user.getId())){
            return userRepo.save(user);
        }

        else
        {
            System.out.println("No user with this id exist");
            return null;
        }

}}

