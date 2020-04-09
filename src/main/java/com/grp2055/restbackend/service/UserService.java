package com.grp2055.restbackend.service;

import com.grp2055.restbackend.models.User;

public interface UserService {
    User findUserById(Long id);
    User findBookingId(Long id);

    //??
    User getAdminStatus(boolean isAdmin);
}
