package com.movie.bms.repo;

import com.movie.bms.model.Screen;
import com.movie.bms.model.Show;
import com.movie.bms.model.enums.ShowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    List<Screen> findByVenueId(Long venueId);

    List<Screen> findByVenueIdAndScreenType(Long venueId, String screenType);
}
