package com.airplane.db.controller;

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

import com.airplane.db.dto.AirplaneDTO;
import com.airplane.db.dto.AirportDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.FlightDTO;
import com.airplane.db.entity.Airplane;
import com.airplane.db.service.FlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flights")
public class FlightController {

		@Resource(name = "FlightService")
		@Autowired
		private FlightService flightService;
		
		@GetMapping("/flights")
		public List<FlightDTO> flights(){
			return flightService.listAllFlights();
			
		}
		
		@GetMapping(value = "/dflights/{dAirport}")
		public List<FlightDTO> flightsDAirport(@PathVariable String dAirport){
			return flightService.listAllFlightsDAir(dAirport);
		}
		
		@GetMapping(value = "/aflights/{aAirport}")
		public List<FlightDTO> flightsAAirport(@PathVariable String aAirport){
			return flightService.listAllFlightsAAir(aAirport);
		}
		
		@GetMapping(value = "/airlineflights/{airline}")
		public List<FlightDTO> flightsAirline(@PathVariable String airline){
			return flightService.listAllFlightsAirline(airline);
		}
		
		@GetMapping(value = "/numberflights/{number}")
		public FlightDTO flightsAirline(@PathVariable int number){
			return flightService.getFlightFNumber(number);
		}
		
		@PostMapping(value = "/search")
		public List<FlightDTO> flightsSearch(@RequestBody FlightDTO flight){
			return flightService.getFlightsSearch(flight);
		}
		
		@PostMapping(value = "/status")
		public FlightDTO flightStatus(@RequestBody FlightDTO flight) {
			
			return flightService.getFlightStatus(flight);
		}
		
		@GetMapping(value = "/passengers/{id}")
		public List<String> getPassengers(@PathVariable int id){
			return flightService.getPassengers(id);
		}
		
		@PostMapping(value = "/create")
		public FlightDTO createFlight(@RequestBody FlightDTO flight) {
			return flightService.createFlight(flight);
		}
		
		@GetMapping(value = "/update/{id}/{status}")
		public FlightDTO updateFlight(@PathVariable int id, @PathVariable String status) {
			return flightService.updateFlight(id, status);
		}
		
		@GetMapping(value = "/viewairplanes/{airline}")
		public List<AirplaneDTO> viewAirplanes(@PathVariable String airline){
			return flightService.viewAirplanes(airline);
		}
		
		@PostMapping(value="addairplane")
		public AirplaneDTO addAirplane(@RequestBody AirplaneDTO airplane) {
			return flightService.addAirplane(airplane);
		}
		
		@PostMapping(value="addairport")
		public AirportDTO addAirplane(@RequestBody AirportDTO airport) {
			return flightService.addAirport(airport);
		}
		
		
		//Date time
//		@GetMapping(value = "/dtimeflights/{airline}")
//		public List<FlightDTO> flightsAirline(@PathVariable String airline){
//			return flightService.listAllFlightsAirline(airline);
//		}
//		
//		@GetMapping(value = "/atimeflights/{airline}")
//		public List<FlightDTO> flightsAirline(@PathVariable String airline){
//			return flightService.listAllFlightsAirline(airline);
//		}

}
