package com.binar.cinema.service;

import com.binar.cinema.entity.Movie;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.ShowTime;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ShowTimeService {
    ShowTime getShowTimeById(Long id);
    ShowTime saveShowTime(ShowTime showTime);
    List<ShowTime> getAllShowTime();
    void deleteShowTime(Long id);
    ShowTime addSeatToShowtime(Long seatId, Long showtimeId);
    ShowTime addMovieToShowtime(Long movieId, Long showtimeId);
    Seat getEnrolledSeat(Long showtimeId);
    Movie getEnrolledMovie(Long showtimeId);
    List<ShowTime> getCurrentFilmShowing(LocalDate date);
    ShowTime getFilmByDate(LocalDate date);
}
