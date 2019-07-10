package com.pablo.tulian.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country implements Serializable{



	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="country_id")
	private int id;
	
	@Column(name="country")
	private String countryNombre;
	
	@Column(name="last_update")
	private Date ultimaActulizacion;
	
	public Country() {
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryNombre() {
		return countryNombre;
	}

	public void setCountryNombre(String countryNombre) {
		this.countryNombre = countryNombre;
	}

	public Date getUltimaActulizacion() {
		return ultimaActulizacion;
	}

	public void setUltimaActulizacion(Date ultimaActulizacion) {
		this.ultimaActulizacion = ultimaActulizacion;
	}
	
	

}
