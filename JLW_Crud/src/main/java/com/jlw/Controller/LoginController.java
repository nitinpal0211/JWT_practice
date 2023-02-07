package com.jlw.Controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlw.Repository.EmployeeRepo;
import com.jlw.model.Employee;

@RestController
public class LoginController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Employee> getLoggedEmployeeDetailsHandler(Authentication auth){
		System.out.println(auth);
		
		Employee emp = empRepo.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("Invalid username or password"));
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
		
		
		 
	}
	
}
