package com.movie.bms.repo;
import com.movie.bms.model.StandUpComedy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StandUpComedyRepository extends JpaRepository<StandUpComedy, Long> {

    List<StandUpComedy> findByComedian(String comedian);
}
