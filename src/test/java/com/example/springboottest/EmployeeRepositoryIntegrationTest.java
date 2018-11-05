package com.example.springboottest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboottest.entity.Employee;
import com.example.springboottest.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	// write test cases here
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
	    Employee alex = new Employee("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Employee found = employeeRepository.findByName(alex.getName());
	 
	    // then
	    assertNotNull(found);
	    
	    assertThat(found.getName())
	    .isEqualTo(alex.getName());
	}

}
