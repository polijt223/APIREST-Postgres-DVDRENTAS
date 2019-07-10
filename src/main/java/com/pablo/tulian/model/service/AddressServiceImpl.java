package com.pablo.tulian.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablo.tulian.model.dao.IAddressDAO;
import com.pablo.tulian.model.entity.Address;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDAO addressDAO;
	
	@Override
	public List<Address> findAll() {
		return addressDAO.findAll();
	}

	@Override
	public Address createAddress(Address address) {
		return addressDAO.save(address);
	}

	@Override
	public Address findById(int id) {
		Optional<Address> optional = addressDAO.findById(id);
		if(optional.get()!=null) {
			return optional.get();
		}
		return null;
	}

}
