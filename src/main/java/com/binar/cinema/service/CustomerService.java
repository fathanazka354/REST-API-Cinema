package com.binar.cinema.service;

import com.binar.cinema.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer getCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void deleteCustomer(Long id);
}
