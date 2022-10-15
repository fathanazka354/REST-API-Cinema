package com.binar.cinema.controller;

import com.binar.cinema.entity.Seat;
import com.binar.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService seatService;
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id){
        return new ResponseEntity<>(seatService.getSeatById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getSeats(){
        return new ResponseEntity<>(seatService.getAllSeats(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Seat> postSeat(@RequestBody Seat seat){
        return new ResponseEntity<>(seatService.saveSeat(seat), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeat(@PathVariable Long id){
        seatService.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
