package com.pablo.tulian.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.tulian.model.dao.IPaymentDAO;
import com.pablo.tulian.model.entity.Payment;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentDAO paymentDAO;
	
	@Override
	public List<Payment> findAll() {
		return paymentDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		paymentDAO.deleteById(id);
	}

	@Override
	public List<Payment> findByIdCustomer(int id) {
		
		return paymentDAO.findByIdCustomer(id);
		
		
	}

}
