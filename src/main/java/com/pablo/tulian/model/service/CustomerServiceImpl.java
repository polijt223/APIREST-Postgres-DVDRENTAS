package com.pablo.tulian.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.tulian.model.dao.ICustomerDAO;
import com.pablo.tulian.model.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public List<Customer> selectCustomerFullRelations() {
		return customerDAO.selectCustomerFullRelations();
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteById(id);
		
	}

	@Override
	public Customer findById(int id) {
		Optional<Customer> optional = customerDAO.findById(id);
		if (optional.get()!=null) {
			return optional.get();
		}
		return null;	
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDAO.save(customer);
	}


}
