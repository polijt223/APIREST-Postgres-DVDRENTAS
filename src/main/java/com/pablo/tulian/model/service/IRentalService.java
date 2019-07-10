package com.pablo.tulian.model.service;

import java.util.List;

import com.pablo.tulian.model.entity.Rental;

public interface IRentalService {

	List<Rental> findByIdCustomer(int id);

	void deleteById(int id);

}
