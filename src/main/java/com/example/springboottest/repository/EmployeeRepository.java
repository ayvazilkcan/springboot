package com.example.springboottest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboottest.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public Employee findByName(String name);
	
}
