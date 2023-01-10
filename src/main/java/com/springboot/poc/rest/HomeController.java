package com.springboot.poc.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.poc.entity.Employee;
import com.springboot.poc.service.*;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private EmployeeService employeeService; 

    @GetMapping(value = {"/","Home"})
    public ModelAndView home() {
        log.info("Rest request to Employee Home page");
        ModelAndView modelAndView = new ModelAndView("EmployeeHome");
        List<Employee> employees = employeeService.getAllEmployee();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
