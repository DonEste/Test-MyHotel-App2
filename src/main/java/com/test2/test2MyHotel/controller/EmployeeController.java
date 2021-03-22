package com.test2.test2MyHotel.controller;

import com.test2.test2MyHotel.model.Employee;
import com.test2.test2MyHotel.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
	private EmployeeService service;
    
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return service.getEmployees();
    }
    
    @PostMapping("/employeesBySalary")
    public List<Employee> findAllVehiculos(@RequestBody String body) throws JSONException {
    	
    	JSONObject jsonRequest= new JSONObject(body);
    	
    	int lowRange = jsonRequest.has("lowRange")? (int)jsonRequest.get("lowRange") : 0;
    	int highRange = jsonRequest.has("highRange")? (int)jsonRequest.get("highRange") : 99999;
    	
    	return service.getemployeesBySalary(lowRange, highRange);
    	//System.out.print(jsonRequest.get("lowRange"));
    }
}
