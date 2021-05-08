package com.airplane.db.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airplane.db.entity.Customer;

@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	SessionFactory sessionFact;

	@Override
	public Customer returnCustomer(String email, String password) {
		Session currentSession = sessionFact.getCurrentSession();
		
		Query query1 = currentSession.createQuery("select c.password from Customer c where c.email = :Cemail").setParameter("Cemail", email);
		
		String realPassword = (String) query1.uniqueResult();
		
		System.out.println(realPassword);
		
		if(realPassword.equals(password)) {
			Query query = currentSession.createQuery("select c.email from Customer c where c.email =:Cemail").setParameter("Cemail", email);
			 String email1 = (String) query.uniqueResult();
			 
			 Customer customer = currentSession.byId(Customer.class).load(email1);
			 return customer;
		 }
		 else {
			 return null;
		 } 
	}

}
