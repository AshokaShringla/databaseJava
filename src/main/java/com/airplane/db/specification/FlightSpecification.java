package com.airplane.db.specification;

import org.springframework.data.jpa.domain.Specification;

import com.airplane.db.entity.Airplane;
import com.airplane.db.entity.Flight;

public class FlightSpecification {
	
	public static Specification<Flight> hasDAirport(String dAirport){
		
		return (flight, cq, cb) -> cb.equal(flight.get("dAirport"), dAirport);
		
	}
	
	public static Specification<Flight> hasAAirport(String aAirport){
		
		return (flight, cq, cb) -> cb.equal(flight.get("aAirport"), aAirport);
		
	}
	
	public static Specification<Flight> hasAirline(String airline){
		
		return (flight, cq, cb) -> cb.equal(flight.get("airline"), airline);
		
	}
	
	public static Specification<Flight> hasFNumber(int fNumber){
		
		return (flight, cq, cb) -> cb.equal(flight.get("id"), fNumber);
		
	}
	
	public static Specification<Flight> hasDDate(java.time.LocalDate dDate){
		
		return (flight, cq, cb) -> cb.equal(flight.get("dDate"), dDate);
		
	}
	
	public static Specification<Flight> hasADate(java.time.LocalDate aDate){
		
		return (flight, cq, cb) -> cb.equal(flight.get("aDate"), aDate);
		
	}
	
	public static Specification<Flight> hasDTime(java.time.LocalTime dTime){
		
		return (flight, cq, cb) -> cb.equal(flight.get("dTime"), dTime);
		
	}
	
	public static Specification<Flight> hasATime(java.time.LocalTime aTime){
		
		return (flight, cq, cb) -> cb.equal(flight.get("aTime"), aTime);
		
	}
	
	public static Specification<Airplane> airplaneAirline(String airline){
		
		return (airplane, cq, cb) -> cb.equal(airplane.get("airline"), airline);
		
	}
	

}
