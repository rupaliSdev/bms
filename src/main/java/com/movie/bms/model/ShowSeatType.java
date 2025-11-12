package com.movie.bms.model;


import com.movie.bms.model.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private int price;

}