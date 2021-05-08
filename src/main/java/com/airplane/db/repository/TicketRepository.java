package com.airplane.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.airplane.db.entity.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket>{
	
	

}
