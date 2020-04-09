package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


}
