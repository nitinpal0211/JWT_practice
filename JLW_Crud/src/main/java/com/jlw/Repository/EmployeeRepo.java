package com.jlw.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlw.model.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Integer >{
	
   public Optional<Employee> findByEmail(String email);
	
}
