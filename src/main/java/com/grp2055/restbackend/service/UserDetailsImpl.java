package com.grp2055.restbackend.service;

import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserRepo users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = users.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username + " Not found in system");
        }

        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
    }


}
