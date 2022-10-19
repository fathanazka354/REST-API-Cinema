package com.binar.cinema.service;

import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.Theater;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService{
    @Autowired
    TheaterRepository theaterRepository;
    @Override
    public Theater getTheaterById(Long id) {
        Optional<Theater> entity = theaterRepository.findById(id);
        return unwrapTheater(entity, id);
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
    static Theater unwrapTheater(Optional<Theater> entity, Long id){
        if (entity.isPresent()) return entity.get();
        throw new DataNotFoundException(id);
    }
}
