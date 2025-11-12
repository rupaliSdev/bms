package com.movie.bms.model;

import com.movie.bms.model.enums.VenueType;
import jakarta.persistence.*;

import java.util.List;

public class Venue extends BaseModel{
    private String name;

    @Enumerated(EnumType.STRING)
    private VenueType venueType;

    private String address;


    private String city;

    private String state;

    private String pincode;

    private Integer totalCapacity;

    @Column(length = 500)
    private String facilities; // Comma-separated: Parking, Food Court, Wheelchair Access

    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL)
    private List<Screen> screens;

    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "venue")
    private List<Show> shows;
}
