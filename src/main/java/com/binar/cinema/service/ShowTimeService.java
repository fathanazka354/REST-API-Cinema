package com.binar.cinema.service;

import com.binar.cinema.entity.ShowTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowTimeService {
    ShowTime getShowTimeById(Long id);
    ShowTime saveShowTime(ShowTime showTime);
    List<ShowTime> getAllShowTime();
    void deleteShowTime(Long id);
}
