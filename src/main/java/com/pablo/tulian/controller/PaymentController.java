package com.pablo.tulian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tulian.model.entity.Payment;
//import com.pablo.tulian.model.entity.Rental;
import com.pablo.tulian.model.service.IPaymentService;
//import com.pablo.tulian.model.service.IRentalService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private IPaymentService servicePayment;
	/*
	@Autowired
	private IRentalService serviceRental;
	*/
	
	@GetMapping("/findall")
	public List<Payment> findAll(){
		
		return servicePayment.findAll();
	}
	
	
	
	
}
