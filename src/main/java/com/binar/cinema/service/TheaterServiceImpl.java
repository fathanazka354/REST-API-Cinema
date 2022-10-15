package com.binar.cinema.service;

import com.binar.cinema.entity.Theater;
import com.binar.cinema.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService{
    @Autowired
    TheaterRepository theaterRepository;
    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).get();
    }

    @Override
    public Theater saveTheater(Theater theater) {
        return theaterRepository.saveAndFlush(theater);
    }

    @Override
    public List<Theater> getAllTheater() {
        return theaterRepository.findAll();
    }

    @Override
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
