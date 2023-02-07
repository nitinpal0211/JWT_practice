package com.jlw.Service;

import java.util.List;

import com.jlw.Exception.EmployeeException;
import com.jlw.model.Employee;

public interface EmployeeService {
	
	
	public Employee registerEmployee (Employee emp) throws EmployeeException;
	public Employee findEmployeeById(Integer id) throws EmployeeException;
	public Employee deleteEmployee(Integer id) throws EmployeeException;
	public Employee updateEmployee(Employee emp) throws EmployeeException;
	public List<Employee> allEmployee() throws EmployeeException;
	public Employee getEmployeeDetailsByEmail(String email) throws EmployeeException;
	

}
