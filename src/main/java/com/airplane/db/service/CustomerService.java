package com.airplane.db.service;

import com.airplane.db.dto.AgentDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.StaffDTO;
import com.airplane.db.entity.Customer;

public interface CustomerService {
	
	public CustomerDTO returnCustomer (String email, String password);
	
	public CustomerDTO returnCustomer1 (CustomerDTO customer);
	
	public CustomerDTO register(CustomerDTO customer);
	
	public AgentDTO returnAgent (AgentDTO agent);
	
	public AgentDTO registerAgent (AgentDTO agent);
	
	public StaffDTO returnStaff (StaffDTO staff);
	
	public StaffDTO registerStaff (StaffDTO staff);

}
