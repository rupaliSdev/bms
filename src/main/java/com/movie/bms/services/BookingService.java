package com.movie.bms.services;

import com.movie.bms.exceptions.*;
import com.movie.bms.model.Booking;
import com.movie.bms.model.Show;
import com.movie.bms.model.ShowSeat;
import com.movie.bms.model.User;
import com.movie.bms.model.enums.BookingStatus;
import com.movie.bms.model.enums.ShowSeatStatus;
import com.movie.bms.model.enums.ShowStatus;
import com.movie.bms.repo.BookingRepository;
import com.movie.bms.repo.ShowRepository;
import com.movie.bms.repo.ShowSeatRepository;
import com.movie.bms.repo.UserRepository;
import jakarta.persistence.OptimisticLockException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired private BookingRepository bookingRepository;
    @Autowired private ShowSeatRepository showSeatRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ShowRepository showRepository;

    @Autowired private PriceCalculationService priceCalculationService;
    private static final int SEAT_BLOCK_TIMEOUT_MINUTES = 10;

    /**
     * Block seats temporarily for user to complete payment
     * Handles concurrent booking attempts with optimistic locking
     */

    public Booking blockSeats(Long userId, Long showId, List<Long> showSeatIds){
        // Validate user
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("user not found with Id "+ userId));
        // Validate show
        Show show= showRepository.findById(showId).orElseThrow(()->new UserNotFoundException("show not found with Id "+showId));

        if(show.getStatus()== ShowStatus.SCHEDULED){
            throw new InvalidShowStatusException("Show is not available for booking. Status: " + show.getStatus());

        }

        //create Booking
        Booking booking= new Booking();
        booking.setUser(user);
        booking.setBookingNumber(generateBookingNumber());
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);

        double totalAmount = 0.0;

        // Block seats with optimistic locking
        for (Long showSeatId :showSeatIds) {
            try {
                ShowSeat showSeat = showSeatRepository.findByIdWithLock(showSeatId)
                        .orElseThrow(() -> new SeatNotFoundException("Seat not found with id: " + showSeatId));

                if (!showSeat.getShow().getId().equals(showId)) {
                    throw new InvalidBookingStateException("Seat does not belong to the show");

                }

                if (showSeat.getStatus() != ShowSeatStatus.AVAILABLE) {
                    if (showSeat.getStatus() == ShowSeatStatus.BLOCKED && isBlockExpired(showSeat.getBlockedAt())) {
                        showSeat.setStatus(ShowSeatStatus.AVAILABLE);
                        showSeat.setBlockedAt(null);
                    } else {
                        throw new SeatNotAvailableException("Seat " + showSeat.getSeat().getSeatNo() + " is not available, status " + showSeat.getStatus());

                    }
                }
                //block the seat

                showSeat.setStatus(ShowSeatStatus.BLOCKED);
                showSeat.setBlockedAt(LocalDateTime.now());
                showSeat.setBooking(booking);
                showSeatRepository.save(showSeat);
            }
            catch(OptimisticLockException e){
                throw new ConcurrentBookingException(
                        "Someone else just booked this seat. Please try again with different seats."
                );
            }
        }

        booking.setPrice(priceCalculationService.calculatePrice(show, showSeatIds));
        return bookingRepository.save(booking);


    }

    private boolean isBlockExpired(LocalDateTime blockedAt) {
        if (blockedAt == null) return false;
        LocalDateTime time= LocalDateTime.now();
        return blockedAt.plusMinutes(SEAT_BLOCK_TIMEOUT_MINUTES).isBefore(time);
    }

    private String generateBookingNumber() {
        return String.valueOf(UUID.randomUUID());
    }

}
