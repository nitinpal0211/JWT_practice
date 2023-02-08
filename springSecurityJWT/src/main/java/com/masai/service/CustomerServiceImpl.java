package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		return customerRepository.save(customer);
		
		
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException {
		
		return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not found with Email: "+email));
	}

	@Override
	public List<Customer> getAllCustomerDetails()throws CustomerException {
		
		List<Customer> customers= customerRepository.findAll();
		
		if(customers.isEmpty())
			throw new CustomerException("No Customer find");
		
		return customers;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(customer.getCustId());
		if(opt.isEmpty()) {
			throw new CustomerException("No Customer found with id "+ customer.getCustId());
		}
		Customer cust = opt.get();
		return customerRepository.save(cust);
	}

	@Override
	public Customer deleteCustomer(Integer id) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(id);
		if(opt.isPresent()) {
			Customer cust = opt.get();
			customerRepository.delete(cust);
			return cust;
		}else {
			throw new CustomerException("No Customer found with id "+ id);
		}
	}

}
