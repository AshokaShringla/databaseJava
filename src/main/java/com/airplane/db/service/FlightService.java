package com.airplane.db.service;

import java.util.List;

import com.airplane.db.dto.AirplaneDTO;
import com.airplane.db.dto.AirportDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.FlightDTO;

public interface FlightService {
	
	public List<FlightDTO> listAllFlights();
	
	public List<FlightDTO> listAllFlightsDAir(String dAirport);
	
	public List<FlightDTO> listAllFlightsAAir(String aAirport);
	
	public List<FlightDTO> listAllFlightsAirline(String airline);
	
	public FlightDTO getFlightFNumber(int fNumber);
	
	public List<FlightDTO> listAllFlightsDDate(java.time.LocalDate dDate);
	
	public List<FlightDTO> listAllFlightsADate(java.time.LocalDate aDate);
	
	public List<FlightDTO> listAllFlightsDTime(java.time.LocalTime dTime);
	
	public List<FlightDTO> listAllFlightsATime(java.time.LocalTime aTime);
	
	public List<FlightDTO> getFlightsSearch(FlightDTO flight);
	
	public FlightDTO getFlightStatus(FlightDTO flight);
	
	public List<String> getPassengers(int id);
	
	public FlightDTO createFlight(FlightDTO flight);
	
	public FlightDTO updateFlight(int id, String status);
	
	public List<AirplaneDTO> viewAirplanes(String airline);
	
	public AirplaneDTO addAirplane(AirplaneDTO airplane);
	
	public AirportDTO addAirport(AirportDTO airport);

}
