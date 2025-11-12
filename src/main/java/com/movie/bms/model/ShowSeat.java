package com.movie.bms.model;

import com.movie.bms.model.enums.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel
{

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus status;

    private Double price;

    private LocalDateTime blockedAt; // For timeout mechanism

    @Version
    private Long version; // For optimistic locking to prevent concurrent bookings

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}
