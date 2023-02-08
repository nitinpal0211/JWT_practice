package com.masai.service;
import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public Customer deleteCustomer(Integer id) throws CustomerException;

}
