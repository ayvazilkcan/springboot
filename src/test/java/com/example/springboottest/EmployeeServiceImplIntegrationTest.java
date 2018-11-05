package com.example.springboottest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboottest.entity.Employee;
import com.example.springboottest.repository.EmployeeRepository;
import com.example.springboottest.service.EmployeeService;
import com.example.springboottest.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
 
    @Autowired
    private EmployeeService employeeService;
 
    @MockBean
    private EmployeeRepository employeeRepository;
 
    // write test cases here
    
    @Before
    public void setUp() {
        Employee alex = new Employee("alex");
        //Employee ilk = new Employee("ilk");
        
        Mockito.when(employeeRepository.findByName(alex.getName()))
          .thenReturn(alex);
    }
    
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "alex";
		Employee found = employeeService.getEmployeeByName(name);

		assertThat(found.getName()).isEqualTo(name);
	}
}
