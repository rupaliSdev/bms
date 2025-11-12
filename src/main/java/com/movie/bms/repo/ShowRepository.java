package com.movie.bms.repo;

import com.movie.bms.model.Show;
import com.movie.bms.model.enums.ShowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


import java.time.LocalDateTime;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByEventIdAndStartTimeBetween(Long eventId, LocalDateTime start, LocalDateTime end);

    List<Show> findByVenueIdAndStartTimeBetween(Long venueId, LocalDateTime start, LocalDateTime end);

    List<Show> findByScreenIdAndStartTimeBetween(Long screenId, LocalDateTime start, LocalDateTime end);

    @Query("SELECT s FROM Show s WHERE s.event.id = :eventId AND s.venue.city = :city AND s.startTime >= :fromDate AND s.status = :status")
    List<Show> findAvailableShowsForEventInCity(Long eventId, String city, LocalDateTime fromDate, ShowStatus status);
}