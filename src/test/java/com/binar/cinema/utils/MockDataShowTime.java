package com.binar.cinema.utils;

import com.binar.cinema.entity.Movie;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.ShowTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MockDataShowTime {
    public ShowTime mockData(ShowTime showTime) throws ParseException {

        Movie movie = new Movie();
        Seat seat = new Seat();
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-12 20:20:20");
        movie.setMovieId(1L);
        movie.setMovieName("Childhood");
        movie.setMovieCode("MO001");
        movie.setCreatedAt(date);
        movie.setCategory("Family");
        movie.setSubTitle("Indonesia");

        seat.setSeatId(1L);
        seat.setSeatCode("SE001");
        seat.setCreatedAt(date);


        showTime.setMovie(movie);
        showTime.setSeat(seat);

        showTime.setShowtimeId(1L);
        showTime.setCreatedAt(date);
        showTime.setMovie(movie);
        return showTime;
    }
}
