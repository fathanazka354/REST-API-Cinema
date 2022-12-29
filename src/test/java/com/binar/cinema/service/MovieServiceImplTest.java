package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.entity.Movie;
import com.binar.cinema.repository.MovieRepository;
import com.binar.cinema.utils.MockDataMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MovieServiceImplTest {

    @Mock private MovieRepository movieRepository;
    @InjectMocks private MovieServiceImpl movieService;

    Movie movie = new Movie();
    Genre genre = new Genre();
    Set<Genre> genres = new HashSet<>();

    @BeforeEach
    void setUp() throws ParseException {
        MockDataMovie mockDataMovie = new MockDataMovie();
        mockDataMovie.mockData(movie, genre, genres);
    }
    @Test
    @DisplayName("When Get Data Movie By Id is Successfull")
    void getMovieById() {
        when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
        var movie1 = movieService.getMovieById(1L);
        assertEquals(movie, movie1);
    }

    @Test
    void saveMovie() {
        when(movieRepository.saveAndFlush(movie)).thenReturn(movie);
        var movieSave = movieService.saveMovie(movie);
        assertEquals(movieSave, movie);

    }

    @Test
    void getAllMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        when(movieRepository.findAll()).thenReturn(movies);
        var movieAll = movieService.getAllMovie();
        assertEquals(movieAll, movies);
    }

    @Test
    void deleteMovie() {
        movieService.deleteMovie(1L);
        verify(movieRepository).deleteById(1L);

//        movieService.deleteMovie(1L);
    }

    @Test
    void getEnrolledGenres() {
        when(movieRepository.findById(1L)).thenReturn(Optional.ofNullable(movie));
        var enrolledGenre = movieService.getEnrolledGenres(1L);
        assertEquals(enrolledGenre, genres);
    }
}