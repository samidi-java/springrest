package com.fis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.exceptions.EmployeeNotFoundException;
import com.fis.model.Employee;
import com.fis.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
    @Autowired
	private EmployeeServiceImpl service;
	
	
    @PostMapping("/employee/create")
    public Employee createEmployee(@RequestBody Employee e) {
		return service.createEmployee(e);
	}
    
    @PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);
	}
    
    @DeleteMapping("/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") int id) {
		service.deleteEmployeeById(id);
	}
    
    @GetMapping("/employee/get/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
    	Employee e=service.getEmployeeById(id);
    	if(e==null)
    		throw new EmployeeNotFoundException("Employee not found for the id: "+id);
		return e;
	}
    @GetMapping("/employee/getAll")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
}
