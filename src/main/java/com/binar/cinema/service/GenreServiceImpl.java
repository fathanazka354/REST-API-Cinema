package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.entity.Movie;
import com.binar.cinema.repository.GenreRepository;
import com.binar.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre addGenreToMovie(Long movieId, Long genreId) {
        Genre genre = getGenreById(genreId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()){
            Movie movie1 = movie.get();
            genre.getMovies().add(movie1);
            return genreRepository.save(genre);
        }
        return null;
    }

    @Override
    public Set<Movie> getEnrolledMovies(Long id) {
        Genre genre = getGenreById(id);
        return genre.getMovies();
    }
}
