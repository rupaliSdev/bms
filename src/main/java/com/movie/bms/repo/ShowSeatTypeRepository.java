package com.movie.bms.repo;

import com.movie.bms.model.Show;
import com.movie.bms.model.enums.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.bms.model.ShowSeatType;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType findAllByShowAndSeatType(Show show, SeatType seatType);

    List<ShowSeatType> findAllByShow(Show show);
    //select * from show_seat_type where show = 100
}

