package com.binar.cinema.service;

import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService{
    @Autowired
    ShowTimeRepository showTimeRepository;
    @Override
    public ShowTime getShowTimeById(Long id) {
        return showTimeRepository.findById(id).get();
    }

    @Override
    public ShowTime saveShowTime(ShowTime showTime) {
        return showTimeRepository.saveAndFlush(showTime);
    }

    @Override
    public List<ShowTime> getAllShowTime() {
        return showTimeRepository.findAll();
    }

    @Override
    public void deleteShowTime(Long id) {
        showTimeRepository.deleteById(id);
    }
}
