package com.movie.bms.model;

import com.movie.bms.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true)
    private String bookingNumber; // BMS2025001234

    private LocalDateTime bookingTime;

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> showSeats;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    private double price;
}