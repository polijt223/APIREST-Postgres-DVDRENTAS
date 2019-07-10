package com.pablo.tulian.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="payment")
public class Payment implements Serializable {

	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="customer_id")
	private int idCustomer;
	
	@Column(name="staff_id")
	private int idStaff;
	
	@Column(name="rental_id")
	private int idRental;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rental_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Rental rental;
	
	
	
	@Column(name="amount")
	private Double importe;
	
	@Column(name="payment_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaPago;
	
	
	public Payment() {
		
	}
	
	
	
	


	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}


	public int getIdStaff() {
		return idStaff;
	}


	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}


	public int getIdRental() {
		return idRental;
	}


	public void setIdRental(int idRental) {
		this.idRental = idRental;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}


	public Date getDiaPago() {
		return diaPago;
	}


	public void setDiaPago(Date diaPago) {
		this.diaPago = diaPago;
	}
	
	
	
	
	
	
	
}
