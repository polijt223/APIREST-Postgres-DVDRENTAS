package com.pablo.tulian.model.service;

import java.util.List;

import com.pablo.tulian.model.entity.Address;

public interface IAddressService {

	public List<Address> findAll();
	public Address createAddress(Address address);
	public Address findById(int idAddress);
}
