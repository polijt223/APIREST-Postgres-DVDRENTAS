package com.pablo.tulian.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.tulian.model.entity.Address;
import com.pablo.tulian.model.entity.Customer;
import com.pablo.tulian.model.entity.Payment;
import com.pablo.tulian.model.entity.Rental;
import com.pablo.tulian.model.service.IAddressService;
import com.pablo.tulian.model.service.ICustomerService;
import com.pablo.tulian.model.service.IPaymentService;
import com.pablo.tulian.model.service.IRentalService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService serviceCustomer;
	@Autowired
	private IPaymentService servicePayment;
	@Autowired
	private IRentalService serviceRental;
	@Autowired
	private IAddressService serviceAddress;
	
	private static final Logger LOG = Logger.getLogger(This.class.getName()); 
	
	@GetMapping("/selectcustomer/all")
	public List<Customer> selectCustomerFullRelations(){
		
		return serviceCustomer.selectCustomerFullRelations();
		
	}
	
	@GetMapping("/selectcustomer/findbyid/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> selectCustomerById(@PathVariable (name="id") int id){
		
		Map<String, Object> response = new HashMap<>();
		Customer cus = new Customer();
		
		try {
			
		cus = serviceCustomer.findById(id);
				
		}catch(NoSuchElementException e) {	
			
			//uso de logger
			LOG.severe("No se encontro al cliente en la base de datos");
			
			response.put("Error", e.getLocalizedMessage());
			response.put("Mensaje", "No se encontro al cliente en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//uso de logger
		LOG.info("Se encontro al cliente en la base de datos");
		
		response.put("mensaje","Se encontro cliente en base de datos");
		response.put("Cliente",cus);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteCustomer(@PathVariable (name = "id") int id) {
		
		Map<String, Object> response = new HashMap<>();
		
			try {
			
				List<Payment> listPayment = servicePayment.findByIdCustomer(id);
				for (Payment payment : listPayment) {
					servicePayment.deleteById(payment.getId());
				}
				
				List<Rental> listRental = serviceRental.findByIdCustomer(id);
				for (Rental rental : listRental) {
					serviceRental.deleteById(rental.getId());
				}
			
			
				serviceCustomer.deleteCustomer(id);
			
			}catch(EmptyResultDataAccessException e) {
				
				//uso de logger
				LOG.severe("No existe el cliente que desea eliminar");
				
				response.put("mensaje", "Error al eliminar el registro de la base de datos");
				response.put("error", e.getMostSpecificCause().getMessage());
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
		//uso de logger
		LOG.info("No existe el cliente que desea eliminar");
		response.put("mensaje", "Se elimino con exito el cliente: "+id);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/createcustomer")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer , BindingResult resultado){
		
		
		@SuppressWarnings("unused") Customer cusNuevo = new Customer();
		@SuppressWarnings("unused") Address addressNuevo = new Address();
		Map<String,Object> response = new HashMap<>();
		
			if(resultado.hasErrors()) {
				for (FieldError errores : resultado.getFieldErrors()) {		LOG.severe(errores.getDefaultMessage());				}
				response.put("Error", obtenerErrores(resultado));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
			try {
				
				
				cusNuevo = customer;
				addressNuevo = serviceAddress.createAddress(customer.getAddress());
				customer.setAddress(null);
				customer.setIdAddress(addressNuevo.getIdAddress());
				cusNuevo = serviceCustomer.createCustomer(cusNuevo);
				
			}catch(DataAccessException dae) {			
				LOG.severe(dae.getLocalizedMessage());
				response.put("Error",dae.getLocalizedMessage());
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		LOG.info("Se creo con exito el nuevo Cliente");
		response.put("Mensaje1", "Se creo con exito la informacion del Cliente");
		response.put("Cliente nuevo",cusNuevo);
		response.put("Direccion nueva",addressNuevo);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}

	@PostMapping("/updatecustomer/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer , BindingResult resultado, @PathVariable (name="id") int id){
		
		Map<String,Object> response = new HashMap<>();
		Customer actualCustomer = new Customer();
		Address actualAddress = new Address();
		
			if(resultado.hasErrors()) {
				for (FieldError errores : resultado.getFieldErrors()) {		LOG.severe(errores.getDefaultMessage());				}
				response.put("Error", obtenerErrores(resultado));
			}
		
		
			try {
				//Se carga los objetos con los datos que ya habia previamente en el sistema
				actualCustomer = serviceCustomer.findById(id);
				actualAddress = serviceAddress.findById(actualCustomer.getIdAddress());		
			}catch(NoSuchElementException e) {	
				LOG.severe("No se encontro al cliente en la base de datos");
				response.put("Error", e.getLocalizedMessage());
				response.put("Mensaje", "No se encontro al cliente en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
			
			try {
				//Se pueblan los objetos con los nuevos datos que se decea actualizar, permite que solo se pueda actualizar ciertos datos
				actualAddress = setearUpdateAddress(actualAddress,customer);
				actualCustomer = setearUpdateCustomer(actualCustomer , customer);
				
				//Se guardan los objetos con los datos ya actualizados para hacer el update
				actualCustomer = serviceCustomer.createCustomer(actualCustomer);
				actualAddress = serviceAddress.createAddress(actualAddress);
				
				
			}catch(DataAccessException dae) {
				LOG.severe(dae.getLocalizedMessage());
				response.put("Error",dae.getLocalizedMessage());
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		
		
		LOG.info("Se actualizo correctamente el Cliente "+ actualCustomer.getNombre() + " "+actualCustomer.getApellido());
		response.put("Mensaje","Se actualizo correctamente el Cliente "+ actualCustomer.getNombre() + " "+actualCustomer.getApellido());
		response.put("Cliente",actualCustomer);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	
	private List<String> obtenerErrores(BindingResult resultado) {
		
	    List<String> errores = resultado.getFieldErrors()
	        .stream()
	        .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
	        .collect(Collectors.toList());
	    return errores;				
    }
	
	private Address setearUpdateAddress(Address actualAddress,Customer customer) {
		
		actualAddress.setAddress(customer.getAddress().getAddress());
		actualAddress.setAddress2(customer.getAddress().getAddress2());
		actualAddress.setCity(customer.getAddress().getCity());
		actualAddress.setCodigoPostal(customer.getAddress().getCodigoPostal());
		actualAddress.setDistrito(customer.getAddress().getDistrito());
		actualAddress.setIdCity(customer.getAddress().getIdCity());
		actualAddress.setNumeroCelular(customer.getAddress().getNumeroCelular());
		actualAddress.setUltimaActulizacion(new Date());
		
		return actualAddress;
	}
	
	private Customer setearUpdateCustomer(Customer actualCustomer , Customer customer) {
		
		actualCustomer.setActive(customer.getActive());
		actualCustomer.setActivebool(customer.isActivebool());
		actualCustomer.setApellido(customer.getApellido());
		actualCustomer.setIdStore(customer.getIdStore());
		actualCustomer.setMail(customer.getMail());
		actualCustomer.setNombre(customer.getNombre());
		actualCustomer.setUltimaActualizacion(new Date());
		
		return actualCustomer;
	}
	
}
