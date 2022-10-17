package com.binar.cinema.service;

import com.binar.cinema.entity.Customer;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer =customerRepository.findById(id);
        return unwrapCustomer(customer, id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    static Customer unwrapCustomer(Optional<Customer> entity, Long id){
        if (entity.isPresent()) return entity.get();
        else throw new DataNotFoundException(id);
    }
}
