package com.airplane.db.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.db.dto.AgentDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.StaffDTO;
import com.airplane.db.entity.Customer;
import com.airplane.db.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {


	@Resource(name = "CustomerService")
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/details/{email}/{password}")
	public CustomerDTO login(@PathVariable String email, @PathVariable String password) {
		
		System.out.println("Hello1");
		CustomerDTO customer1 = customerService.returnCustomer(email, password);
		
		System.out.println(customer1);
		return customer1;
	}
	
	@PostMapping(value="/login")
	public CustomerDTO login(@RequestBody CustomerDTO customer) {
		return customerService.returnCustomer1(customer);
	}
	
	@PostMapping(value = "/register")
	public CustomerDTO register(@RequestBody CustomerDTO customer) {
		return customerService.register(customer);
	}
	
	@PostMapping(value="/agentlogin")
	public AgentDTO agentLogin(@RequestBody AgentDTO agent) {
		return customerService.returnAgent(agent);
	}
	
	@PostMapping(value = "/agentregister")
	public AgentDTO agentRegister(@RequestBody AgentDTO agent) {
		return customerService.registerAgent(agent);
	}
	
	@PostMapping(value="/stafflogin")
	public StaffDTO staffLogin(@RequestBody StaffDTO staff) {
		return customerService.returnStaff(staff);
	}
	
	@PostMapping(value = "/staffregister")
	public StaffDTO staffRegister(@RequestBody StaffDTO staff) {
		return customerService.registerStaff(staff);
	}
	
}
