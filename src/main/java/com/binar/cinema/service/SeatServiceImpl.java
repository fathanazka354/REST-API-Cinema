package com.binar.cinema.service;

import com.binar.cinema.entity.Payment;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.Theater;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.SeatRepository;
import com.binar.cinema.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public Seat getSeatById(Long id) {
        Optional<Seat> entity = seatRepository.findById(id);
        return unwrapSeat(entity, id);
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.saveAndFlush(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Seat addSeatToTheater(Long seatId, Long theaterId) {
        Optional<Seat> entity = seatRepository.findById(seatId);
        Seat seat = unwrapSeat(entity, seatId);
        Optional<Theater> theater = theaterRepository.findById(theaterId);
        if (theater.isPresent()){
            seat.setTheater(theater.get());
            return seatRepository.saveAndFlush(seat);
        }
        return null;
    }

    @Override
    public Theater getEnrolledTheater(Long seatId) {
        Optional<Seat> entity = seatRepository.findById(seatId);
        Seat seat = unwrapSeat(entity, seatId);
        return seat.getTheater();
    }

    static Seat unwrapSeat(Optional<Seat> entity, Long id){
        if (entity.isPresent()) return entity.get();
        throw new DataNotFoundException(id);
    }
}
