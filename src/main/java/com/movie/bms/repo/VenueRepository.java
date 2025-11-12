package com.movie.bms.repo;

import com.movie.bms.model.Venue;
import com.movie.bms.model.enums.VenueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    List<Venue> findByCity(String city);

    List<Venue> findByCityAndVenueType(String city, VenueType venueType);

    List<Venue> findByNameContainingIgnoreCase(String name);

    List<Venue> findByVenueType(VenueType venueType);
}