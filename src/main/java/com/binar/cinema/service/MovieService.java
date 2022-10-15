package com.binar.cinema.service;

import com.binar.cinema.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    Movie getMovieById(Long id);
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovie();
    void deleteMovie(Long id);
}
