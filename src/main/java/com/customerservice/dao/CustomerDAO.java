package com.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerservice.entity.Customer;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	@Query(value = "select c from Customer c where c.custEmail=?1")
	public Customer findByCustEmail(String custEmail);
}
