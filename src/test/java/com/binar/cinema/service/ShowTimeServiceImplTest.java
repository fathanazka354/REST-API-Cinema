package com.binar.cinema.service;

import com.binar.cinema.entity.*;
import com.binar.cinema.repository.MovieRepository;
import com.binar.cinema.repository.SeatRepository;
import com.binar.cinema.repository.ShowTimeRepository;
import com.binar.cinema.utils.MockDataMovie;
import com.binar.cinema.utils.MockDataSeatTheater;
import com.binar.cinema.utils.MockDataShowTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ShowTimeServiceImplTest {

    @Mock private ShowTimeRepository showTimeRepository;
    @Mock private MovieRepository movieRepository;
    @Mock private SeatRepository seatRepository;
    @InjectMocks private ShowTimeServiceImpl showTimeService;

    ShowTime showTime = new ShowTime();
    Seat seat = new Seat();
    Theater theater = new Theater();
    Movie movie = new Movie();
    Genre genre = new Genre();
    Set<Genre> genres = new HashSet<>();
    ShowTime showTimeMock;
    @BeforeEach
    void setUp() throws ParseException {
        MockDataShowTime mockDataShowTime = new MockDataShowTime();
        MockDataSeatTheater mockDataSeatTheater = new MockDataSeatTheater();
        MockDataMovie mockDataMovie = new MockDataMovie();
        seat = mockDataSeatTheater.seatDataFaker(seat, theater);
        movie = mockDataMovie.mockData(movie, genre, genres);
         showTimeMock = mockDataShowTime.mockData(showTime);
    }
    @Test
    void getShowTimeById() {
        when(showTimeRepository.findById(1L)).thenReturn(Optional.ofNullable(showTimeMock));
        var id = showTimeService.getShowTimeById(1L);
        assertEquals(id.getShowtimeId(), showTimeMock.getShowtimeId());
    }

    @Test
    void saveShowTime() {
        when(showTimeRepository.saveAndFlush(showTimeMock)).thenReturn(showTimeMock);
        var showTimeSave = showTimeService.saveShowTime(showTimeMock);
        assertEquals(showTimeSave, showTimeMock);
    }

    @Test
    void getAllShowTime() {
        List<ShowTime> showTimes = new ArrayList<>();
        showTimes.add(showTimeMock);
        when(showTimeRepository.findAll()).thenReturn(showTimes);
        var showTimeAll = showTimeService.getAllShowTime();
        assertEquals(showTimeAll, showTimes);
    }

    @Test
    void deleteShowTime() {
        showTimeService.deleteShowTime(1L);
        verify(showTimeRepository).deleteById(1L);
    }

    @Test
    void addSeatToShowtime() {
        when(seatRepository.findById(1L)).thenReturn(Optional.ofNullable(seat));
        when(showTimeRepository.findById(1L)).thenReturn(Optional.ofNullable(showTimeMock));
        when(showTimeRepository.saveAndFlush(showTimeMock)).thenReturn(showTimeMock);
        var showTimeSave = showTimeService.addSeatToShowtime(1L,1L);
        assertEquals(showTimeSave, showTimeMock);
    }

    @Test
    void addMovieToShowtime() {
        when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
        when(showTimeRepository.findById(1L)).thenReturn(Optional.ofNullable(showTimeMock));
        when(showTimeRepository.saveAndFlush(showTimeMock)).thenReturn(showTimeMock);
        var showTimeSave = showTimeService.addMovieToShowtime(1L,1L);
        assertEquals(showTimeSave, showTimeMock);
    }

    @Test
    void getEnrolledSeat() {
        when(seatRepository.findById(1L)).thenReturn(Optional.ofNullable(seat));
        when(showTimeRepository.findById(1L)).thenReturn(Optional.ofNullable(showTimeMock));
        var seatSave = showTimeService.getEnrolledSeat(1L);
        assertEquals(seatSave, showTimeMock.getSeat());
    }

    @Test
    void getEnrolledMovie() {
        when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
        when(showTimeRepository.findById(1L)).thenReturn(Optional.ofNullable(showTimeMock));
        var movieSave = showTimeService.getEnrolledMovie(1L);
        assertEquals(movieSave, showTimeMock.getMovie());
    }

    @Test
    void getCurrentFilmShowing() {
        LocalDate lt
                = LocalDate.now();
        List<ShowTime> showTimes = new ArrayList<>();
        showTimes.add(showTimeMock);
        when(showTimeRepository.findFilmThatShowing(lt)).thenReturn(showTimes);
        var showTimeCurrent = showTimeService.getCurrentFilmShowing(lt);
        assertEquals(showTimeCurrent, showTimes);
    }

    @Test
    void getFilmByDate() {
        LocalDate lt
                = LocalDate.now();
        when(showTimeRepository.findFilmByDate(lt)).thenReturn(showTimeMock);
        var showTimeFilmByData = showTimeService.getFilmByDate(lt);
        assertEquals(showTimeFilmByData, showTimeMock);
    }
}