package com.fis.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fis.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeAdvice {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException e)
	{
		return new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);
	}

}
