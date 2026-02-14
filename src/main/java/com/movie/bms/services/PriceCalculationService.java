package com.movie.bms.services;

import com.movie.bms.model.Seat;
import com.movie.bms.model.Show;
import com.movie.bms.model.ShowSeat;
import com.movie.bms.model.ShowSeatType;
import com.movie.bms.model.enums.SeatType;
import com.movie.bms.repo.ShowSeatRepository;
import com.movie.bms.repo.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    @Autowired private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired private ShowSeatRepository showSeatRepository;

    public double calculatePrice(Show show, List<Long> showSeatIds) {
        List<ShowSeatType> showSeatTypes=showSeatTypeRepository.findAllByShow(show);
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        double totalPrice =0;

        for(ShowSeat showSeat:showSeats){
            for (ShowSeatType showSeatType:showSeatTypes){
                if(showSeat.getSeat().getType().equals(showSeatType.getSeatType())){
                    totalPrice+=showSeatType.getPrice();
                }
            }
        }
        return totalPrice;
    }
}
