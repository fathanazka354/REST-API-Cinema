package com.binar.cinema.service;

import com.binar.cinema.entity.Theater;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TheaterServiceImplTest {
    @Mock private TheaterRepository theaterRepository;
    @InjectMocks private TheaterServiceImpl theaterService;

    Theater theater = new Theater();
    @BeforeEach
    private void setUp() throws ParseException {
        MockDataSeatTheater mockDataSeatTheater = new MockDataSeatTheater();
        theater = mockDataSeatTheater.seatDataTheaterFaker(theater);
    }

    @Test
    void getTheaterById() {
        when(theaterRepository.findById(1L)).thenReturn(Optional.ofNullable(theater));
        var theaterData = theaterService.getTheaterById(1L);
        assertEquals(theaterData, theater);
    }

    @Test
    void saveTheater() {
        when(theaterRepository.saveAndFlush(theater)).thenReturn(theater);
        var theaterData = theaterService.saveTheater(theater);
        assertEquals(theaterData, theater);
    }

    @Test
    void getAllTheater() {
        List<Theater> theaters = new ArrayList<>();
        theaters.add(theater);
        when(theaterRepository.findAll()).thenReturn(theaters);
        var theaterData = theaterService.getAllTheater();
        assertEquals(theaterData, theaters);
    }

    @Test
    void deleteTheater() {
        theaterService.deleteTheater(1L);
        verify(theaterRepository).deleteById(1L);
    }
}