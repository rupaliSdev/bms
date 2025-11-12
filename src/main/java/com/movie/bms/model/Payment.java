package com.movie.bms.model;

import com.movie.bms.model.enums.PaymentMode;
import com.movie.bms.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment extends BaseModel {

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;

    private LocalDateTime paymentTime;

    @Column(length = 1000)
    private String gatewayResponse; // JSON response from payment gateway
}
