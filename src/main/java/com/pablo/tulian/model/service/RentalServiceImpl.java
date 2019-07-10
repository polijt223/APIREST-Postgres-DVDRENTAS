package com.pablo.tulian.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.tulian.model.dao.IRentalDAO;
import com.pablo.tulian.model.entity.Rental;

@Service
public class RentalServiceImpl implements IRentalService {

	@Autowired
	private IRentalDAO rentalDAO;

	@Override
	public List<Rental> findByIdCustomer(int id) {
		return rentalDAO.findByIdCustomer(id) ;
	}

	@Override
	public void deleteById(int id) {
		rentalDAO.deleteById(id);
		
	}
	
	
}
