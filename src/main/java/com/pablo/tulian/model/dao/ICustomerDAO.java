package com.pablo.tulian.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pablo.tulian.model.entity.Customer;

@Repository
public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

	
	@Query("select cus from Customer cus order by cus.idCustomer ") 
	public List<Customer> selectCustomerFullRelations();
	
}
