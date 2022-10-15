package com.binar.cinema.service;

import com.binar.cinema.entity.Genre;
import com.binar.cinema.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    GenreRepository genreRepository;
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

    }
}
