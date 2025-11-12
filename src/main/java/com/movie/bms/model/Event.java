package com.movie.bms.model;

import com.movie.bms.model.enums.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Event extends BaseModel{

   private String title;
   private  Language language;
   private String description;
   @Enumerated(EnumType.STRING)
   private EventType eventType;

    private Integer durationMinutes;
    private String genre;
    @OneToMany(mappedBy = "event" ,cascade=CascadeType.ALL)
    private List<Show> shows;

}
