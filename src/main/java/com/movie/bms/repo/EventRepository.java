package com.movie.bms.repo;

import com.movie.bms.model.Event;
import com.movie.bms.model.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventType(EventType eventType);

    @Query("SELECT e FROM Event e JOIN e.shows s JOIN s.venue v WHERE v.city = :city AND e.eventType = :eventType")
    List<Event> findByEventTypeAndCity(EventType eventType, String city);

    List<Event> findByTitleContainingIgnoreCase(String title);

    List<Event> findByGenre(String genre);
}