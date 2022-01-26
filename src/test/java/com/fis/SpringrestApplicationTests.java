package com.fis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fis.model.Employee;
import com.fis.repository.EmployeeRepository;
import com.fis.service.EmployeeServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringrestApplicationTests {
	
	@InjectMocks
	private EmployeeServiceImpl service;
	
	@Mock
	private EmployeeRepository repository;
	
	@Test
	public void test1()
	{
		Employee e1=new Employee();
		e1.setId(101);
		e1.setName("samidi");
		e1.setSalary(50000);
		
		Employee e2=new Employee();
		e2.setId(101);
		e2.setName("samidi");
		e2.setSalary(50000);
		
		List<Employee> expectedList=new ArrayList<>();
		expectedList.add(e1);
		expectedList.add(e2);
		
		Mockito.when(repository.findAll()).thenReturn(expectedList);
		
		List<Employee> actualList= service.getAllEmployees();
		
		assertEquals(expectedList.size(), actualList.size());
	}
	
	@Test
	public void test2()
	{
		int expected=30;
		int actual=service.sum(10, 20);
		
		assertEquals(expected, actual);
	}
	@Test
	public void test3()
	{
		assertEquals(1, 1);
	}
	

}
