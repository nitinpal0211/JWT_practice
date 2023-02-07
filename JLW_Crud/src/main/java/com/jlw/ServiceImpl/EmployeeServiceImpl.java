package com.jlw.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlw.Exception.EmployeeException;
import com.jlw.Repository.EmployeeRepo;
import com.jlw.Service.EmployeeService;
import com.jlw.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired(required = true)
	private EmployeeRepo empRepo;

	
	// this method will register a new Employee
	@Override
	public Employee registerEmployee(Employee emp) {
		Employee newEmp = empRepo.save(emp);
		return newEmp;
	}

	// this method will return a particular Employee
	@Override
	public Employee findEmployeeById(Integer id) throws EmployeeException {
	Optional<Employee> opt=	empRepo.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}else {
		throw new EmployeeException("No Employee found with id "+ id);
	}
	}

	// this method will delete a particular EMployee
	@Override
	public Employee deleteEmployee(Integer id) throws EmployeeException {
		Optional<Employee> opt= empRepo.findById(id);
		if(opt.isPresent()) {
		Employee emp= opt.get();
			empRepo.delete(emp); 
			return  emp;
		}else {
			throw new EmployeeException("No Employee found with id "+ id);
		}
		
	}

	
	// this method will update an Employee
	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		Optional<Employee> opt= empRepo.findById(emp.getId());
		
		if(opt.isPresent()) {
		 Employee updatedEmp = empRepo.save(emp);
		 return updatedEmp;
		}else {
			throw new EmployeeException("No Employee found with the given id "+ emp.getId());
		}
		
	}

	
	// this method will return a List of all Employee
	@Override
	public List<Employee> allEmployee() throws EmployeeException {
		
		List<Employee> allEmp = empRepo.findAll();
		
		if(allEmp.size()>0) {
			return allEmp;
		}else {
			throw new EmployeeException("No Employee Found");
		}
		
	}

	
	// this method will return Details of an Employee 
	@Override
	public Employee getEmployeeDetailsByEmail(String email) throws EmployeeException {
		return empRepo.findByEmail(email).orElseThrow(()-> new EmployeeException("No Employee found with this eamil " +email));
	}

	
	
	
	
    
	

}
