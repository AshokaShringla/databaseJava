package com.airplane.db.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.airplane.db.dto.AirplaneDTO;
import com.airplane.db.dto.AirportDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.FlightDTO;
import com.airplane.db.dto.TicketDTO;
import com.airplane.db.entity.Airplane;
import com.airplane.db.entity.Airport;
import com.airplane.db.entity.Flight;
import com.airplane.db.entity.Payment;
import com.airplane.db.entity.Ticket;
import com.airplane.db.repository.AirplaneRepository;
import com.airplane.db.repository.AirportRepository;
import com.airplane.db.repository.CustomerRepository;
import com.airplane.db.repository.FlightRepository;
import com.airplane.db.repository.TicketRepository;
import com.airplane.db.specification.FlightSpecification;
import com.airplane.db.specification.TicketSpecification;

@Service ("FlightService")
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	AirplaneRepository airplaneRepository;
	
	@Autowired
	AirportRepository airportRepository;
	
	@Override
	public List<FlightDTO> listAllFlights() {
		
		List<Flight> flights = flightRepository.findAll();
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsDAir(String dAirport) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasDAirport(dAirport));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsAAir(String aAirport) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasAAirport(aAirport));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsADate(java.time.LocalDate aDate) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasADate(aDate));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsATime(java.time.LocalTime aTime) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasATime(aTime));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public FlightDTO getFlightFNumber(int FNumber) {
		
		Flight flight1 = flightRepository.findOne(FlightSpecification.hasFNumber(FNumber)).get();
		
		return getFlightDTO(flight1);
		
	}
	
	@Override
	public List<FlightDTO> listAllFlightsDDate(java.time.LocalDate dDate) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasDDate(dDate));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsDTime(java.time.LocalTime dTime) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasDTime(dTime));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> listAllFlightsAirline(String airline) {
		List<Flight> flights = flightRepository.findAll(FlightSpecification.hasAirline(airline));
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight flight1 : flights) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	@Override
	public List<FlightDTO> getFlightsSearch(FlightDTO search){
		
		boolean dAirport = false;
		boolean aAirport = false;
		boolean date = false;
		
		List<Flight> result = new ArrayList<>();
		
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		if(search.getdAirport() != null) {
			dAirport = true;
		}
		if(search.getaAirport() != null) {
			aAirport = true;
		}
		if(search.getdDate() != null) {
			date = true;
		}
		
		System.out.println("Here");
		System.out.println(dAirport + " " + aAirport + " " + date);
		
		if(dAirport && !aAirport && !date) {
			result = flightRepository.findAll(FlightSpecification.hasDAirport(search.getdAirport()));
		}
		else if(!dAirport && aAirport && !date) {
			result = flightRepository.findAll(FlightSpecification.hasAAirport(search.getaAirport()));
		}
		else if(dAirport && aAirport && !date) {
			result = flightRepository.findAll(FlightSpecification.hasDAirport(search.getdAirport()).and(FlightSpecification.hasAAirport(search.getaAirport())));
		}
		else if(!dAirport && !aAirport && date) {
			result = flightRepository.findAll(FlightSpecification.hasDDate(search.getdDate()));
		}
		else if(dAirport && !aAirport && date) {
			result = flightRepository.findAll(FlightSpecification.hasDAirport(search.getdAirport()).and(FlightSpecification.hasDDate(search.getdDate())));
		}
		else if(!dAirport && aAirport && date) {
			result = flightRepository.findAll(FlightSpecification.hasAAirport(search.getaAirport()).and(FlightSpecification.hasDDate(search.getdDate())));
		}
		else if(dAirport && aAirport && date) {
			result = flightRepository.findAll(FlightSpecification.hasDAirport(search.getdAirport()).and(FlightSpecification.hasAAirport(search.getaAirport())).and(FlightSpecification.hasDDate(search.getdDate())));
		}
		else if(!dAirport && !aAirport && !date) {
			result = flightRepository.findAll();
		}
		
		for (Flight flight1 : result) {
			flightsDTO.add(getFlightDTO(flight1));
		}
		
		return flightsDTO;
	}
	
	public FlightDTO getFlightStatus(FlightDTO flight) {
		
		Flight result = new Flight();
		
		if(flight.getdDate() == null) {
			result = flightRepository.findOne(FlightSpecification.hasAirline(flight.getAirline()).and(FlightSpecification.hasFNumber(flight.getId())).and(FlightSpecification.hasADate(flight.getaDate()))).get();
		}
		else {
			result = flightRepository.findOne(FlightSpecification.hasAirline(flight.getAirline()).and(FlightSpecification.hasFNumber(flight.getId())).and(FlightSpecification.hasDDate(flight.getdDate()))).get();
		}
		
		return getFlightDTO(result);
	}
	
	public List<String> getPassengers(int id){
		List<String> custs = new ArrayList<>();
		List<Ticket> ticks = ticketRepository.findAll(TicketSpecification.hasFId(id));

		for (Ticket ticket : ticks) {
			custs.add(ticket.getcEmail());
		}
		
		return custs;
	}
	
	public FlightDTO createFlight(FlightDTO flight) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Flight flightEntity = modelMapper.map(flight, Flight.class);
		
		
		flightRepository.save(flightEntity);
		flightRepository.flush();
		return getFlightDTO(flightEntity);
		
	}
	
	public FlightDTO updateFlight(int id, String status) {
		Flight flight = flightRepository.findOne(FlightSpecification.hasFNumber(id)).get();
		
		flight.setStatus(status);
		
		flightRepository.save(flight);
		
		return getFlightDTO(flight);
	}
	
	public List<AirplaneDTO> viewAirplanes(String airline){
		List<Airplane> airplanes = airplaneRepository.findAll(FlightSpecification.airplaneAirline(airline));
		List<AirplaneDTO> airplanes1 = new ArrayList<>();
		
		for (Airplane airplane : airplanes) {
			airplanes1.add(getAirplaneDTO(airplane));
		}
		
		return airplanes1;
	}
	
	public AirplaneDTO addAirplane(AirplaneDTO airplane) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Airplane airplaneEntity = modelMapper.map(airplane, Airplane.class);
		
		airplaneRepository.saveAndFlush(airplaneEntity);
		return getAirplaneDTO(airplaneEntity);
	}
	
	public AirportDTO addAirport(AirportDTO airport) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Airport airportEntity = modelMapper.map(airport, Airport.class);
		
		airportRepository.saveAndFlush(airportEntity);
		return getAirportDTO(airportEntity);
	}
	
	private FlightDTO getFlightDTO(final Flight flight) {
		
		FlightDTO flightDTO = new FlightDTO();
		
		flightDTO.setId(flight.getId());
		flightDTO.setAirline(flight.getAirline());
		flightDTO.setaId(flight.getaId());
		flightDTO.setdDate(flight.getdDate());
		flightDTO.setdTime(flight.getdTime());
		flightDTO.setaDate(flight.getaDate());
		flightDTO.setaTime(flight.getaTime());
		flightDTO.setdAirport(flight.getdAirport());
		flightDTO.setaAirport(flight.getaAirport());
		flightDTO.setbPrice(flight.getbPrice());
		flightDTO.setStatus(flight.getStatus());
		
		return flightDTO;
		
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
	
	private AirplaneDTO getAirplaneDTO(final Airplane airplane) {
		
		AirplaneDTO airplaneDTO = new AirplaneDTO();
		
		airplaneDTO.setId(airplane.getId());
		airplaneDTO.setAirline(airplane.getAirline());
		airplaneDTO.setSeats(airplane.getSeats());
		
		return airplaneDTO;
	}
	
	private AirportDTO getAirportDTO(final Airport airport) {
		
		AirportDTO airport1 = new AirportDTO();
		
		airport1.setCity(airport.getCity());
		airport1.setName(airport.getName());
		
		return airport1;
	}

}
