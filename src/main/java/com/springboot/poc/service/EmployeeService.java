package com.springboot.poc.service;

import com.springboot.poc.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    void deleteByID(Long id);
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeByID(Long id);
    Optional<Employee> getEmployeeByName(String name);
}
