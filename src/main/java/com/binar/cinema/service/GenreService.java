package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface GenreService {
    Genre getGenreById(Long id);
    Genre saveGenre(Genre genre);
    List<Genre> getAllGenre();
    void deleteGenre(Long id);
    Genre addGenreToMovie(Long movieId, Long genreId);
    Set<Movie> getEnrolledMovies(Long id);
}
