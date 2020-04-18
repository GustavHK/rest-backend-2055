package com.grp2055.restbackend.repositories;

import com.grp2055.restbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(exported=false)
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String id);
}
