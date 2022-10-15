package com.binar.cinema.service;

import com.binar.cinema.entity.Movie;
import com.binar.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
