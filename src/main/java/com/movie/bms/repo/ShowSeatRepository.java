package com.movie.bms.repo;

import com.movie.bms.model.ShowSeat;
import com.movie.bms.model.enums.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findByShowIdAndStatus(Long showId, ShowSeatStatus status);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT ss FROM ShowSeat ss WHERE ss.id = :id")
    Optional<ShowSeat> findByIdWithLock(Long id);

    @Query("SELECT ss FROM ShowSeat ss WHERE ss.show.id = :showId AND ss.seat.seatType = :seatType")
    List<ShowSeat> findByShowIdAndSeatType(Long showId, String seatType);
}