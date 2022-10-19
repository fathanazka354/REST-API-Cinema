package com.binar.cinema.service;

import com.binar.cinema.entity.Employee;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> entity = employeeRepository.findById(id);
        return unwrapEmployee(entity, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    static Employee unwrapEmployee(Optional<Employee> entity, Long id){
        if (entity.isPresent()) return entity.get();
        throw new DataNotFoundException(id);
    }
}
