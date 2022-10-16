package com.binar.cinema.controller;

import com.binar.cinema.entity.Movie;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.ShowTime;
import com.binar.cinema.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/date={date}")
    public ResponseEntity<ShowTime> getDataByDate(@PathVariable("date") @RequestBody String searchKey){
        return new ResponseEntity<>(showTimeService.getFilmByDate(LocalDate.parse(searchKey)), HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<List<ShowTime>> getCurrentData(){
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate getNow = LocalDate.now();
        return new ResponseEntity<>(showTimeService.getCurrentFilmShowing(LocalDate.parse(formatTanggal.format(getNow))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShowTime> postSeat(@RequestBody ShowTime showTime){
        return new ResponseEntity<>(showTimeService.saveShowTime(showTime), HttpStatus.CREATED);
    }

    @PutMapping("/{showtimeId}/seat/{seatId}")
    public ResponseEntity<ShowTime> addSeatToShowtime(@PathVariable Long showtimeId,@PathVariable Long seatId){
        return new ResponseEntity<>(showTimeService.addSeatToShowtime(seatId, showtimeId), HttpStatus.CREATED);
    }

    @GetMapping("/{showtimeId}/seat")
    public ResponseEntity<Seat> getEnrolledSeat(@PathVariable Long showtimeId){
        return new ResponseEntity<>(showTimeService.getEnrolledSeat(showtimeId), HttpStatus.CREATED);
    }

    @PutMapping("/{showtimeId}/movie/{movieId}")
    public ResponseEntity<ShowTime> addMovieToShowtime(@PathVariable Long showtimeId, @PathVariable Long movieId){
        return new ResponseEntity<>(showTimeService.addMovieToShowtime(movieId, showtimeId), HttpStatus.CREATED);
    }

    @GetMapping("/{showtimeId}/movie")
    public ResponseEntity<Movie> getEnrolledMovie(@PathVariable Long showtimeId){
        return new ResponseEntity<>(showTimeService.getEnrolledMovie(showtimeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeat(@PathVariable Long id){
        showTimeService.deleteShowTime(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
