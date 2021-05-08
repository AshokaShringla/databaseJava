package com.airplane.db.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.db.dto.FlightDTO;
import com.airplane.db.dto.PaymentDTO;
import com.airplane.db.dto.TicketDTO;
import com.airplane.db.service.PaymentService;
import com.airplane.db.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Resource(name = "TicketService")
	@Autowired
	private TicketService ticketService;
	
	@Resource(name = "PaymentService")
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/ctickets/{email}")
	public List<TicketDTO> cTickets(@PathVariable String email){
		return ticketService.listAllCTickets(email);
		
	}
	
	@GetMapping("/fctickets/{email}")
	public List<TicketDTO> fcTickets(@PathVariable String email){
		return ticketService.listAllfCTickets(email);
		
	}
	
	@GetMapping("/pctickets/{email}")
	public List<TicketDTO> pcTickets(@PathVariable String email){
		return ticketService.listAllpCTickets(email);
		
	}
	
	@GetMapping("/flightctickets/{email}")
	public List<FlightDTO> flightcTickets(@PathVariable String email){
		return ticketService.listAllCFlights(email);
		
	}
	
	@GetMapping("/agent/{id}")
	public List<FlightDTO> agent(@PathVariable int id){
		return ticketService.listAgent(id);
	}
	
	@GetMapping("/flightfctickets/{email}")
	public List<FlightDTO> flightfcTickets(@PathVariable String email){
		return ticketService.listAllfCFlights(email);
		
	}
	
	@GetMapping("/flightpctickets/{email}")
	public List<FlightDTO> flightpcTickets(@PathVariable String email){
		return ticketService.listAllpCFlights(email);
		
	}
	
	@PostMapping("/buyticket/{email}/{id}/{bid}")
	public FlightDTO buyTicket(@PathVariable String email, @PathVariable int id, @PathVariable int bid, @RequestBody FlightDTO flight) {
		return ticketService.buyTicket(flight, email, id, bid);
	}

	@PostMapping("/addpayment")
	public PaymentDTO addpayment(@RequestBody PaymentDTO payment) {
		payment = paymentService.addPayment(payment);
		return payment;
	}
	
	@GetMapping("/agentcommission/{id}/{months}")
	public List<Integer> commissions(@PathVariable int id, @PathVariable int months){
		return ticketService.getComissions(id, months);
	}
	
	
	
	
}
