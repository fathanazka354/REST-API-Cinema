package com.binar.cinema.repository;

import com.binar.cinema.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
}
