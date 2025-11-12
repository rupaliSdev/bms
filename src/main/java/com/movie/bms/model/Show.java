package com.movie.bms.model;

import com.movie.bms.model.enums.ShowStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    // For movies in theatres, screen is specified
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats;

}
