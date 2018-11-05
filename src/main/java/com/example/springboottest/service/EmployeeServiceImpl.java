package com.example.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboottest.entity.Employee;
import com.example.springboottest.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeByName(String name) {
		
		return employeeRepository.findByName(name);
	}

}
