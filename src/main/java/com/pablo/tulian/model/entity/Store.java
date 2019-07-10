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
@Table(name="store")
public class Store implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id")
	private int id;
	
	@Column(name="manager_staff_id")
	private int idManagerStaff;
	
	
	@Column(name="address_id")
	private int idAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="address_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Address address;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;
	
	public Store() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdManagerStaff() {
		return idManagerStaff;
	}

	public void setIdManagerStaff(int idManagerStaff) {
		this.idManagerStaff = idManagerStaff;
	}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	
	
}
