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
@Table(name="address")
public class Address implements Serializable {


	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int idAddress;
	
	@Column(name="address")
	private String address;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="district")
	private String distrito;
	
	@Column(name="city_id")
	private int idCity;
	
	@Column(name="postal_code")
	private String codigoPostal;
	
	@Column(name="phone")
	private String numeroCelular;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActulizacion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private City city;
	
	
	public Address() {
		
	}
	
	
	
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}






	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Date getUltimaActulizacion() {
		return ultimaActulizacion;
	}

	public void setUltimaActulizacion(Date ultimaActulizacion) {
		this.ultimaActulizacion = ultimaActulizacion;
	}
	
	
	
	
	
	
	
	

}
