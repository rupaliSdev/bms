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
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceCalculationService {

    @Autowired private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired private ShowSeatRepository showSeatRepository;
    public double calculatePrice(Show show, List<Long> showSeatIds) {
        List<ShowSeatType> showSeatTypes=showSeatTypeRepository.findAllByShow(show);
        double price =0.0;
        Map<SeatType,Double> seatTypePrice = showSeatTypes.stream().collect(Collectors.toMap(
                ShowSeatType::getSeatType,
                ShowSeatType::getPrice));

        List<ShowSeat> showSeats= showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat:showSeats){
           price+=seatTypePrice.get(showSeat.getSeat().getType());
        }
        return price;

    }
}
