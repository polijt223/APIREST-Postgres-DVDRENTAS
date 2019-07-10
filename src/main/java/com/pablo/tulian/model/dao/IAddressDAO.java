package com.pablo.tulian.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablo.tulian.model.entity.Address;

public interface IAddressDAO extends JpaRepository<Address, Integer> {

}
