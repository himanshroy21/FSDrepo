package com.customerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customerservice.dao.CustomerDAO;
import com.customerservice.entity.Customer;

@SpringBootTest
class CustomerServiceApplicationTests {
	
@Autowired
CustomerDAO customerdao;
	
	@Test
	void contextLoads() {
	}

	@Test
	void addCustomer() {
		Customer customer=new Customer(11,"Hemu","Maratahalli",null,"hemu@gmailcom","HeMu12");
		customerdao.save(customer);
		assertNotNull(customerdao.findById(11).get());
	}
	@Test
	void addCustomer1() {
		Customer customer=new Customer(12,"Raj","Bangalore",null,"raj@gmailcom","Raj12");
		customerdao.save(customer);
		assertNotNull(customerdao.findById(12).get());
	}
	@Test
	void getAllCustomers() {
		Customer customer=customerdao.getById(14);
		assertEquals(14,customer.getCustomerId());
	}
}
