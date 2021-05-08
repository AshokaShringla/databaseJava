package com.airplane.db.specification;

import org.springframework.data.jpa.domain.Specification;

import com.airplane.db.entity.Payment;
import com.airplane.db.entity.Ticket;

public class TicketSpecification {
	
	public static Specification<Ticket> hasCEmail(String email){
		
		return (ticket, cq, cb) -> cb.equal(ticket.get("cEmail"), email);
		
	}
	
	public static Specification<Ticket> hasFId(int id){
		
		return (ticket, cq, cb) -> cb.equal(ticket.get("fId"), id);
		
	}
	
	public static Specification<Ticket> hasBId(int id){
		
		return (ticket, cq, cb) -> cb.equal(ticket.get("baID"), id);
		
	}

}
