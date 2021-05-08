package com.airplane.db.dao;

import com.airplane.db.entity.Customer;

public interface CustomerDao {

	public Customer returnCustomer (String email, String password);
	
}
