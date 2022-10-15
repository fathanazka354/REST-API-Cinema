package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    Genre getGenreById(Long id);
    Genre saveGenre(Genre genre);
    List<Genre> getAllGenre();
    void deleteGenre(Long id);
}
