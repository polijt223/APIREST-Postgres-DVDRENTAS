package com.pablo.tulian.model.service;

import java.util.List;


import com.pablo.tulian.model.entity.Customer;;;
public interface ICustomerService {
	
	public List<Customer> selectCustomerFullRelations();
	public Customer findById(int id);
	public void deleteCustomer(int id);
	public Customer createCustomer(Customer customer);
	
}
