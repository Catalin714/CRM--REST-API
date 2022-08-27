package com.selflearning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selflearning.entity.Customer;
import com.selflearning.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	
	//autowire Customer service
	@Autowired
	CustomerService customerService;
	
	
	
	
	//add mapping for GET /customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		
		return customerService.getCustomers();
		
		
	}
	
	//add mapping for Get /customers/{customerId}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId)
	{
		
		if(customerService.getCustomer(customerId).equals(null))
		{
			
			throw new CustomerNotFoundException("Customer id not found- "+customerId);
		}
		return customerService.getCustomer(customerId);
		
		
		
		
	}
	
	//add mapping for adding a customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer)
	{
		// we set id to 0 because  in saveOrUpdate function from Hibernate if primary key is empty (empty means 0 or null)
		// then insert a new customer else update an existing customer
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
		
	}
	
	
	//add mapping for update an existing customer
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		
		customerService.saveCustomer(theCustomer);
		
		
		return theCustomer;
	}
	
	
    //add mapping for delete an existing customer
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		if(customerService.getCustomer(customerId).equals(null))
		{
			
			throw new CustomerNotFoundException("Customer id not found "+customerId);
		}
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id-" +customerId;
	
}
	}
