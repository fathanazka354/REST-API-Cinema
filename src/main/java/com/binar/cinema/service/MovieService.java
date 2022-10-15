package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MovieService {
    Movie getMovieById(Long id);
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovie();
    void deleteMovie(Long id);
    Set<Genre> getEnrolledGenres(Long id);
}
