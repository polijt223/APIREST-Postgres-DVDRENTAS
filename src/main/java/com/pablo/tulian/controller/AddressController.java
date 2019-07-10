package com.pablo.tulian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tulian.model.entity.Address;
import com.pablo.tulian.model.service.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressService serviceAddress;
	
	
	@GetMapping("/findall")
	public List<Address> findAll(){
		return serviceAddress.findAll();
	}
	
	
	
}
