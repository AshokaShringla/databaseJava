package com.airplane.db.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplane.db.dto.FlightDTO;
import com.airplane.db.dto.PaymentDTO;
import com.airplane.db.dto.TicketDTO;
import com.airplane.db.entity.Flight;
import com.airplane.db.entity.Payment;
import com.airplane.db.entity.Ticket;
import com.airplane.db.repository.FlightRepository;
import com.airplane.db.repository.TicketRepository;
import com.airplane.db.specification.TicketSpecification;

@Service ("TicketService")
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Resource(name = "FlightService")
	@Autowired
	private FlightService flightService;
	
	@Resource(name = "PaymentService")
	@Autowired
	private PaymentService paymentService;

	@Override
	public List<TicketDTO> listAllCTickets(String email) {
		
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<TicketDTO> tickets1 = new ArrayList<>();
		
		for (Ticket ticket : tickets) {
			tickets1.add(getTicketDTO(ticket));
		}
		
		return tickets1;
	}
	
	@Override
	public List<TicketDTO> listAllfCTickets(String email) {
		
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<TicketDTO> tickets1 = new ArrayList<>();
		
		LocalDate now = LocalDate.now();
		LocalTime now1 = LocalTime.now();
		FlightDTO flight;

		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			
			if((flight.getaDate().isAfter(now))) {
				if(flight.getaTime().isAfter(now1)) {
					tickets1.add(getTicketDTO(ticket));
				}
			}
		}
		
		return tickets1;
	}
	
	@Override
	public List<TicketDTO> listAllpCTickets(String email) {
		
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<TicketDTO> tickets1 = new ArrayList<>();

		LocalDate now = LocalDate.now();
		LocalTime now1 = LocalTime.now();
		FlightDTO flight;
		
		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			
			if((flight.getaDate().isBefore(now))) {
				if(flight.getaTime().isBefore(now1)) {
					tickets1.add(getTicketDTO(ticket));
				}
			}
		}
		
		return tickets1;
	}
	
	@Override
	public List<FlightDTO> listAllCFlights(String email) {
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<FlightDTO> flights1 = new ArrayList<>();
		
		FlightDTO flight;
		
		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			flights1.add(flight);
		}
		
		return flights1;
	}

	@Override
	public List<FlightDTO> listAllfCFlights(String email) {
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<FlightDTO> flights1 = new ArrayList<>();
		

		LocalDate now = LocalDate.now();
		LocalTime now1 = LocalTime.now();
		FlightDTO flight;
		
		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			
			if((flight.getaDate().isAfter(now))) {
				if(flight.getaTime().isAfter(now1)) {
					flights1.add(flight);
				}
			}
		}
		
		return flights1;
	}

	@Override
	public List<FlightDTO> listAllpCFlights(String email) {
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasCEmail(email));
		List<FlightDTO> flights1 = new ArrayList<>();
		

		LocalDate now = LocalDate.now();
		LocalTime now1 = LocalTime.now();
		FlightDTO flight;
		
		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			
			if((flight.getaDate().isBefore(now))) {
				if(flight.getaTime().isBefore(now1)) {
					flights1.add(flight);
				}
			}
		}
		
		return flights1;
	}
	
	public FlightDTO buyTicket(FlightDTO flight, String email, int id, int bid) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		
		TicketDTO ticket = new TicketDTO();
		ticket.setAirline(flight.getAirline());
		ticket.setcEmail(email);
		ticket.setfId(flight.getId());
		ticket.setsPrice(flight.getbPrice());
		ticket.setpId(id);
		
		if(bid != 0) {
			ticket.setBaID(bid);
		}
		
		ticket.setpTime(LocalDateTime.now().toString());
		
		Ticket ticketEntity = modelMapper.map(ticket, Ticket.class);
		ticketRepository.save(ticketEntity);
		
		return flight;
	}
	
	public List<FlightDTO> listAgent(int id){
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasBId(id));
		List<FlightDTO> flights1 = new ArrayList<>();
		
		FlightDTO flight;
		
		
		for (Ticket ticket : tickets) {
			flight = flightService.getFlightFNumber(ticket.getfId());
			flights1.add(flight);
		}
		
		return flights1;
	}
	
	public List<Integer> getComissions(int id, int months){
		
		List<Integer> comissions = new ArrayList<>();
		
		List<Ticket> tickets = ticketRepository.findAll(TicketSpecification.hasBId(id));
		
		LocalDateTime month = LocalDateTime.now().minusMonths(months);
		
		int one = 0;
		int two = 0;
		int three = 0;
		
		for (Ticket ticket : tickets) {
			if(LocalDateTime.parse(ticket.getpTime()).isAfter(month)) {
				one += (ticket.getsPrice()/1.1);
				three ++;
			}
		}
		
		two = one/three;
		
		comissions.add(one);
		comissions.add(two);
		comissions.add(three);
		
		return comissions;
		
	}
	
	private TicketDTO getTicketDTO(final Ticket ticket) {
		
		TicketDTO ticketDTO = new TicketDTO();
		
		ticketDTO.setId(ticket.getId());
		ticketDTO.setcEmail(ticket.getcEmail());
		ticketDTO.setAirline(ticket.getAirline());
		ticketDTO.setfId(ticket.getfId());
		ticketDTO.setsPrice(ticket.getsPrice());
		ticketDTO.setpId(ticket.getpId());
		ticketDTO.setpTime(ticket.getpTime());
		ticketDTO.setBaID(ticket.getBaID());
		
		return ticketDTO;
		
	}

}
