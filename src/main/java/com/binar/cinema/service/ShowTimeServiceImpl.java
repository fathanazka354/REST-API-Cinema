package com.binar.cinema.service;

import com.binar.cinema.entity.Movie;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.repository.MovieRepository;
import com.binar.cinema.repository.SeatRepository;
import com.binar.cinema.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeServiceImpl implements ShowTimeService{
    @Autowired
    ShowTimeRepository showTimeRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    MovieRepository movieRepository;
    @Override
    public ShowTime getShowTimeById(Long id) {
        return showTimeRepository.findById(id).get();
    }

    @Override
    public ShowTime saveShowTime(ShowTime showTime) {
        return showTimeRepository.saveAndFlush(showTime);
    }

    @Override
    public List<ShowTime> getAllShowTime() {
        return showTimeRepository.findAll();
    }

    @Override
    public void deleteShowTime(Long id) {
        showTimeRepository.deleteById(id);
    }

    @Override
    public ShowTime addSeatToShowtime(Long seatId, Long showtimeId) {
        ShowTime showTime = getShowTimeById(showtimeId);
        Optional<Seat> seat = seatRepository.findById(seatId);
        if (seat.isPresent()){
            showTime.setSeat(seat.get());
            return showTimeRepository.saveAndFlush(showTime);
        }
        return null;
    }

    @Override
    public ShowTime addMovieToShowtime(Long movieId, Long showtimeId) {
        ShowTime showTime = getShowTimeById(showtimeId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()){
            showTime.setMovie(movie.get());
            return showTimeRepository.saveAndFlush(showTime);
        }
        return null;
    }

    @Override
    public Seat getEnrolledSeat(Long showtimeId) {
        ShowTime showTime = getShowTimeById(showtimeId);
        return showTime.getSeat();
    }

    @Override
    public Movie getEnrolledMovie(Long showtimeId) {
        ShowTime showTime = getShowTimeById(showtimeId);
        return showTime.getMovie();
    }

    @Override
    public List<ShowTime> getCurrentFilmShowing(LocalDate date) {
        return showTimeRepository.findFilmThatShowing(date);
    }

    @Override
    public ShowTime getFilmByDate(LocalDate date) {
        return showTimeRepository.findFilmByDate(date);
    }
}
