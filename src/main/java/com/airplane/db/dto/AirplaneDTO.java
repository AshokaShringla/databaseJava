package com.airplane.db.dto;

import javax.persistence.Column;

public class AirplaneDTO {
	
	int id;

	String airline;

	int seats;

	public AirplaneDTO() {
		super();
	}

	public AirplaneDTO(int id, String airline, int seats) {
		super();
		this.id = id;
		this.airline = airline;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "AirplaneDTO [id=" + id + ", airline=" + airline + ", seats=" + seats + "]";
	}

}
