package com.test2.test2MyHotel.service;

import com.test2.test2MyHotel.model.Employee;
import com.test2.test2MyHotel.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }
}
