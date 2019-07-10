package com.pablo.tulian.model.service;

import java.util.List;

import com.pablo.tulian.model.entity.Payment;

public interface IPaymentService {
	
	public List<Payment> findAll();

	public void deleteById(int id);
	
	public List<Payment> findByIdCustomer(int id);
	
}
