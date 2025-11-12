package com.movie.bms.model;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class User extends BaseModel{

    String name;
    @Column(unique = true)
    String email;
    String password;// Should be encrypted in production

    @OneToMany(mappedBy = "user")
    List<Booking> bookings;
}
