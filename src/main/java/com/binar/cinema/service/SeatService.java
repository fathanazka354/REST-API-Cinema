package com.binar.cinema.service;

import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.Theater;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface SeatService {
    Seat getSeatById(Long id);
    Seat saveSeat(Seat seat);
    List<Seat> getAllSeats();
    void deleteSeat(Long id);
    Seat addSeatToTheater(Long seatId, Long theaterId);
    Theater getEnrolledTheater(Long seatId);
}
