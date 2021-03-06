package com.grp2055.restbackend.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ListIndexBase;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name="user")
public class User extends BaseEntity {
    public User() {
        super(); // Henter id fra baseentity
    }
    public User(String username, String firstName, String lastName, String password, String role, String campusId){
        this();
        this.username = username;
        this.firstName=firstName;
        this.lastName = lastName;
        setPassword(password);
        this.role = role;
        this.campusId = campusId;
    }

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();


    @Column(name = "first_name")
    String firstName;

    @Column(name = "username")
    String username;

    @Column(name = "last_name")
    String lastName;

    @Column(name ="campus_id")
    String campusId;

    @Column(name = "role", nullable = false)
    @JsonIgnore
    public String role;


    @JsonIgnore
    @Column(name ="password")
    private String password;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }


    @ElementCollection()
    @CollectionTable(name="booking", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "id")
    private Set<Integer> bookingList = new HashSet<>();

}

