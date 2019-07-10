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
@Table(name="city")
public class City implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="city_id")
	private int idCity;
	
	@Column(name="city")
	private String cityNombre;

	@Column(name="country_id")
	private int id;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActulizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Country country;
	
	public City() {
		
	}
	
	
	
	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getCityNombre() {
		return cityNombre;
	}

	public void setCityNombre(String cityNombre) {
		this.cityNombre = cityNombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUltimaActulizacion() {
		return ultimaActulizacion;
	}

	public void setUltimaActulizacion(Date ultimaActulizacion) {
		this.ultimaActulizacion = ultimaActulizacion;
	}
	
	
	
	
}
