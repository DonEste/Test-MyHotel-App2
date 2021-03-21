package com.test2.test2MyHotel.controller;

import com.test2.test2MyHotel.model.Employee;
import com.test2.test2MyHotel.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
	private EmployeeService service;
    
    @GetMapping("/employee/{id}")
    public Employee findVehiculoById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
}
