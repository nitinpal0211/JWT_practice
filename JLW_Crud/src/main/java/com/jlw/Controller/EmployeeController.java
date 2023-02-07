package com.jlw.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jlw.Exception.EmployeeException;
import com.jlw.Service.EmployeeService;
import com.jlw.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	// this method will return a ResponseEntity of new register Employee
		@PostMapping("/employee")
		public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee emp) throws EmployeeException{
			
		     // here we are converting given password to hash  password
			emp.setPassword(passwordEncoder.encode(emp.getPassword()));
			
			Employee newEmp = empService.registerEmployee(emp);
			return new ResponseEntity<Employee>(newEmp,HttpStatus.CREATED);
			
		}
	
	// this method will return a ResponseEntity List of Employees
	@GetMapping("/employee/allEmployee")
	public ResponseEntity<List<Employee>> AllEmployeeHandler() throws EmployeeException{
		List<Employee> allEmp = empService.allEmployee(); 
		
	return new ResponseEntity<List<Employee>>(allEmp,HttpStatus.ACCEPTED);
	}
	
	
	//this method will return  a ResponseEntity of an Employee based on id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployeeWithIdHandler(@PathVariable("id") Integer id) throws EmployeeException{
		Employee emp = empService.findEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	
	
	//this method will return  a ResponseEntity of an Employee based on emialid
	@GetMapping("/employee/{email}")
	public ResponseEntity<Employee> getEmployeeByEmailHandler(@PathVariable("email") String email) throws EmployeeException{
		Employee emp = empService.getEmployeeDetailsByEmail(email);
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}

	
	// this method will return a ResponseEntity of Deleted Employee
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployeeHandler(@PathVariable("id") Integer id) throws EmployeeException{
		Employee emp = empService.deleteEmployee(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	
	// this method will return a ResponseEntity of updated Employee
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee emp) throws EmployeeException{
		Employee employee = empService.updateEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	
	
}
