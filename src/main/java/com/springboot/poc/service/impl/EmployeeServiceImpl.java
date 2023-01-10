package com.springboot.poc.service.impl;

import com.springboot.poc.entity.Employee;
import com.springboot.poc.repository.EmployeeRepository;
import com.springboot.poc.service.AddressService;
import com.springboot.poc.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        log.info("Request to save Employee");
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteByID(Long id) {
        log.info("Request to Delete by Id : {0}", id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        log.info("Request to Get All Employee");
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeByID(Long id) {
        log.info("Request to Get Employee by Id: {0}", id);
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> getEmployeeByName(String name) {
        log.info("Request to Get Employee by Name: {0}", name);
        return employeeRepository.findByName(name);
    }
}
