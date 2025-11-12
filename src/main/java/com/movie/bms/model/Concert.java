package com.movie.bms.model;

import com.movie.bms.model.enums.ConcertGenre;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("CONCERT")
public class Concert extends Event{
    private String artist;

    private String band;

    @Enumerated(EnumType.STRING)
    private ConcertGenre concertGenre;
}
