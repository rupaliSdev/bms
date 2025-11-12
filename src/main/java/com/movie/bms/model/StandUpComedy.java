package com.movie.bms.model;

import com.movie.bms.model.enums.ComedyGenre;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@DiscriminatorValue("STANDUP")
public class StandUpComedy extends Event {

    private String comedian;

    @Enumerated(EnumType.STRING)
    private ComedyGenre comedyGenre;

    private String ageRestriction; // 18+, All ages

}