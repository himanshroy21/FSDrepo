package com.customerservice.service;

import java.util.List;

import com.customerservice.entity.Customer;
import com.customerservice.exception.CustomerNotFoundException;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException;
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomerById(Integer customerId);
}
