package com.binar.cinema.service;

import com.binar.cinema.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    Seat getSeatById(Long id);
    Seat saveSeat(Seat seat);
    List<Seat> getAllSeats();
    void deleteSeat(Long id);
}
