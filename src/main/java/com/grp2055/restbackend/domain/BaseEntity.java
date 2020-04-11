package com.grp2055.restbackend.domain;


import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {

    @Column(name="id", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;
    protected BaseEntity() {
        id = 0;
    }
}
