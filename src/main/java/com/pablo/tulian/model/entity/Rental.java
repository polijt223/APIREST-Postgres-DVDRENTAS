package com.pablo.tulian.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rental")
public class Rental implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int id;
	
	@Column(name="rental_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaRentado;
	
	@Column(name="inventory_id")
	private int idInventory;
	
	@Column(name="customer_id")
	private int idCustomer;
	
	@Column(name="return_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaDevuelto;
	
	@Column(name="staff_id")
	private int idStaff;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;

	
	public Rental () {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDiaRentado() {
		return diaRentado;
	}

	public void setDiaRentado(Date diaRentado) {
		this.diaRentado = diaRentado;
	}

	public int getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(int idInventory) {
		this.idInventory = idInventory;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Date getDiaDevuelto() {
		return diaDevuelto;
	}

	public void setDiaDevuelto(Date diaDevuelto) {
		this.diaDevuelto = diaDevuelto;
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	
	
	
}
