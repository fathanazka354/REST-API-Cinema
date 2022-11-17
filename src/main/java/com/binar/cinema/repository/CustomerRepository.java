package com.binar.cinema.repository;

import com.binar.cinema.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String name);
}
