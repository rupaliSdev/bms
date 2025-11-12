package com.movie.bms.model;

import com.movie.bms.model.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    int row;
    int col;
    int seatNo;

    @Enumerated(EnumType.STRING)
    SeatType type;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    Screen screen;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;


}
