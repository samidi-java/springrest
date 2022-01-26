package com.fis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.model.Employee;
import com.fis.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee createEmployee(Employee e) {
		return repository.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return repository.save(e);
	}

	@Override
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> opt=repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	
	public int sum(int a,int b)
	{
		return a+b;
	}

}
