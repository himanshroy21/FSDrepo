package com.customerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@Column(name = "customerid")
	private Integer customerId;
	@Column(name = "customername")
	private String customerName;
	@Column(name = "custemail")
	private String custEmail;
	@Column(name = "custphoneno")
	private Long custPhoneNo;
	@Column(name = "custAddress")
	private String custAddress;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	

	public Customer(Integer customerId, String customerName, String custEmail, Long custPhoneNo, String custAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custEmail = custEmail;
		this.custPhoneNo = custPhoneNo;
		this.custAddress = custAddress;
	}

	public Customer(Integer customerId, String customerName, String custEmail, Long custPhoneNo, String custAddress,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custEmail = custEmail;
		this.custPhoneNo = custPhoneNo;
		this.custAddress = custAddress;
		this.password = password;
	}

	public Customer() {
		super();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public Long getCustPhoneNo() {
		return custPhoneNo;
	}

	public void setCustPhoneNo(Long custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", custEmail=" + custEmail
				+ ", custPhoneNo=" + custPhoneNo + ", custAddress=" + custAddress + "]";
	}

}
