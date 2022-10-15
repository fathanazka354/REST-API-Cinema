package com.binar.cinema.service;

import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.entity.Theater;

import java.util.List;

public interface TheaterService {
    Theater getTheaterById(Long id);
    Theater saveTheater(Theater theater);
    List<Theater> getAllTheater();
    void deleteTheater(Long id);
}
