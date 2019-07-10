package com.pablo.tulian.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pablo.tulian.model.entity.Rental;

public interface IRentalDAO extends JpaRepository<Rental, Integer> {

	@Query("select ren from Rental ren where ren.idCustomer= ?1")
	List<Rental> findByIdCustomer(int id);

}
