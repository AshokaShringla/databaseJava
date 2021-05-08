package com.airplane.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airplane")
public class Airplane {

	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="airline")
	String airline;
	
	@Column(name="seats")
	int seats;

	public Airplane() {
		super();
	}

	public Airplane(int id, String airline, int seats) {
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
		return "Airplane [id=" + id + ", airline=" + airline + ", seats=" + seats + "]";
	}
	
}
