package com.movie.bms.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends Event{

    private String name;

    private List<Actor> casts;

    private List<Language> languages;

    private double rating;

    private String director;

}
