package com.test2.test2MyHotel.service;

import com.test2.test2MyHotel.model.Employee;
import com.test2.test2MyHotel.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
    	return employeeRepository.findAll();
    }
    
    public List<Employee> getemployeesBySalary(int lowRange, int highRange){
    	return employeeRepository.findSalaryRange((double)lowRange, (double)highRange);
    }
}
