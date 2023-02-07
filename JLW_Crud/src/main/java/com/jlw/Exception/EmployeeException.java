package com.jlw.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class EmployeeException extends Exception {
	
	public EmployeeException() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	

}
