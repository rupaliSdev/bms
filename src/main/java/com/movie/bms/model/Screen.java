package com.movie.bms.model;

import com.movie.bms.model.enums.Feature;
import jakarta.persistence.*;

import java.util.List;

public class Screen extends BaseModel{

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    List<Seat> seats;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> shows;
    @Enumerated(EnumType.STRING)
    Feature screenType;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

}
