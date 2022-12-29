package com.binar.cinema.service;

import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.entity.Theater;
import com.binar.cinema.repository.SeatRepository;
import com.binar.cinema.repository.TheaterRepository;
import com.binar.cinema.utils.MockDataSeatTheater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SeatServiceImplTest {

    @Mock private SeatRepository seatRepository;
    @Mock private TheaterRepository theaterRepository;
    @InjectMocks private SeatServiceImpl seatService;

    Seat seat = new Seat();
    Theater theater = new Theater();
    ShowTime showTime = new ShowTime();
    @BeforeEach
    void setUp() throws ParseException {
        MockDataSeatTheater mockDataSeatTheater = new MockDataSeatTheater();
        mockDataSeatTheater.seatDataFaker(seat, theater);
//        seat
    }
    @Test
    void getSeatById() {
        when(seatRepository.findById(1L)).thenReturn(Optional.ofNullable(seat));
        var id = seatService.getSeatById(1L);
        assertEquals(id.getSeatId(), seat.getSeatId());
    }

    @Test
    void saveSeat() {
        when(seatRepository.saveAndFlush(seat)).thenReturn(seat);
        var seatSave = seatService.saveSeat(seat);
        assertEquals(seatSave, seat);
    }

    @Test
    void getAllSeats() {
        List<Seat> seats = new ArrayList<>();
        seats.add(seat);
        when(seatRepository.findAll()).thenReturn(seats);
        var seatAll = seatService.getAllSeats();
        assertEquals(seatAll, seats);
    }

    @Test
    void deleteSeat() {
        seatService.deleteSeat(1L);
        verify(seatRepository).deleteById(1L);
    }

    @Test
    void addSeatToTheater() {
        when(theaterRepository.findById(1L)).thenReturn(Optional.ofNullable(theater));
        when(seatRepository.findById(1L)).thenReturn(Optional.ofNullable(seat));
        when(seatRepository.saveAndFlush(seat)).thenReturn(seat);
        var theaterSave = seatService.addSeatToTheater(1L,1L);
        assertEquals(theaterSave, seat);
    }

    @Test
    void getEnrolledTheater() {
        when(seatRepository.findById(1L)).thenReturn(Optional.ofNullable(seat));
        var getTheater = seatService.getEnrolledTheater(1L);
        assertEquals(getTheater, theater);
    }
}