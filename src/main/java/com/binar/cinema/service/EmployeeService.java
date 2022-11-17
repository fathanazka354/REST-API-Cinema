package com.binar.cinema.service;

import com.binar.cinema.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    boolean deleteEmployee(Long id);
}
