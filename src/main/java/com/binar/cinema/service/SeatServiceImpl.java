package com.binar.cinema.service;

import com.binar.cinema.entity.Seat;
import com.binar.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SeatRepository seatRepository;
    @Override
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).get();
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
}
