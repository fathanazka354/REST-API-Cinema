package com.binar.cinema.utils;

import com.binar.cinema.entity.Customer;
import com.binar.cinema.entity.Seat;
import com.binar.cinema.entity.Theater;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MockDataSeatTheater {
    public Seat seatDataFaker(Seat seat, Theater theater) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-12 20:20:20");
        theater.setTheaterId(1L);
        theater.setTheaterCode("TE001");
        theater.setCreatedAt(date);
        theater.setTheaterId(1L);

        seat.setTheater(theater);
        seat.setSeatId(1L);
        seat.setSeatCode("SE001");
        seat.setCreatedAt(date);

        return seat;
    }

    public Theater seatDataTheaterFaker(Theater theater) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-12 20:20:20");
        theater.setTheaterId(1L);
        theater.setTheaterCode("TE001");
        theater.setCreatedAt(date);
        theater.setTheaterId(1L);

        return theater;
    }
}
