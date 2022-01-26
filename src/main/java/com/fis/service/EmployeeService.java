package com.fis.service;

import java.util.List;

import com.fis.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee e);
	public Employee updateEmployee(Employee e);
	public void deleteEmployeeById(int id);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();

}
