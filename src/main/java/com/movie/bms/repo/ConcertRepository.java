package com.movie.bms.repo;

import com.movie.bms.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    List<Concert> findByArtist(String artist);

    List<Concert> findByBand(String band);
}