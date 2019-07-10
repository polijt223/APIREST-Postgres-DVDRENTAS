package com.pablo.tulian.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pablo.tulian.model.entity.Payment;

public interface IPaymentDAO extends JpaRepository<Payment, Integer> {

	@Query("delete from Payment pay where pay.idCustomer= ?1")
	void deleteByIdCustomer(int id);

	@Query("select pay from Payment pay where pay.idCustomer= ?1")
	List<Payment> findByIdCustomer(int id);

}
