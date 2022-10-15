package com.binar.cinema.controller;

import com.binar.cinema.entity.Employee;
import com.binar.cinema.entity.Genre;
import com.binar.cinema.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id){
        return new ResponseEntity<>(genreService.getGenreById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getGenres(){
        return new ResponseEntity<>(genreService.getAllGenre(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genre> postGenre(@RequestBody Genre genre){
        return new ResponseEntity<>(genreService.saveGenre(genre), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGenre(@PathVariable Long id){
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
