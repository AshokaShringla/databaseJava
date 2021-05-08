package com.airplane.db.service;

import java.util.List;

import com.airplane.db.dto.FlightDTO;
import com.airplane.db.dto.PaymentDTO;
import com.airplane.db.dto.TicketDTO;

public interface TicketService {
	
	public List<TicketDTO> listAllCTickets(String email);
	
	public List<TicketDTO> listAllfCTickets(String email);
	
	public List<TicketDTO> listAllpCTickets(String email);
	
	public List<FlightDTO> listAllCFlights(String email);
	
	public List<FlightDTO> listAllfCFlights(String email);
	
	public List<FlightDTO> listAllpCFlights(String email);
	
	public FlightDTO buyTicket(FlightDTO flight, String email, int id, int bid);
	
	public List<FlightDTO> listAgent(int id);

	public List<Integer> getComissions(int id, int months);

}
