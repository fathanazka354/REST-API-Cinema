package com.binar.cinema.utils;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.entity.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class MockDataMovie {
    public Movie mockData(Movie movie, Genre genre, Set<Genre> genres) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-12 20:20:20");

        genre.setGenreId(1L);
        genre.setNameGenre("Family");
        genre.setCreatedAt(date);
        genres.add(genre);

        movie.setMovieId(1L);
        movie.setMovieName("Childhood");
        movie.setMovieCode("MO001");
        movie.setCreatedAt(date);
        movie.setCategory("Family");
        movie.setGenres(genres);
        movie.setSubTitle("Indonesia");
        return movie;
    }
}
