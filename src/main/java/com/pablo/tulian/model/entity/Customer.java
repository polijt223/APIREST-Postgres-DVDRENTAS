package com.pablo.tulian.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="customer")
public class Customer implements Serializable{

	
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int idCustomer;
	
	@Column(name="store_id")
	private int idStore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="store_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Store store;
	
	@Column(name="first_name")
	private String nombre;
	
	@Column(name="last_name")
	private String apellido;
	
	@Column(name="email")
	private String mail;
	
	@Column(name="address_id")
	private int idAddress;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name="address_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Address address;
	
	@Column(name="activebool")
	private boolean activebool;
	
	@Column(name="create_date")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	private Date ultimaActualizacion;
	
	@Column(name="active")
	private int active;
	
	
	public Customer() {
		
	}
	
	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getIdStore() {
		return idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public boolean isActivebool() {
		return activebool;
	}

	public void setActivebool(boolean activebool) {
		this.activebool = activebool;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	
	
	
	
	
	
	
	
}
