package com.movie.bms.repo;

import com.movie.bms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByLanguage(String language);

    List<Movie> findByRatingGreaterThanEqual(Double rating);

    List<Movie> findByCertification(String certification);

    List<Movie> findByDirector(String director);
}