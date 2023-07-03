package com.customerservice.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.customerservice.dao.CustomerDAO;
import com.customerservice.entity.Customer;
import com.customerservice.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		Customer c;
		if (customerDao.findById(customerId).isEmpty()) {
			throw new CustomerNotFoundException();
		} else {
			c = customerDao.findById(customerId).get();
		}
		return c;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomerById(Integer customerId) {
		Customer c = customerDao.getById(customerId);
		customerDao.delete(c);

	}
	@Bean
	private BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
