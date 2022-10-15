package com.binar.cinema.controller;

import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtime")
public class ShowTimeController {
    @Autowired
    ShowTimeService showTimeService;
    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> getShowTimeById(@PathVariable Long id){
        return new ResponseEntity<>(showTimeService.getShowTimeById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShowTime>> getShowTimes(){
        return new ResponseEntity<>(showTimeService.getAllShowTime(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShowTime> postSeat(@RequestBody ShowTime showTime){
        return new ResponseEntity<>(showTimeService.saveShowTime(showTime), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeat(@PathVariable Long id){
        showTimeService.deleteShowTime(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
