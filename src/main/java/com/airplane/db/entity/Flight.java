package com.airplane.db.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.*;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="airline")
	String airline;

	@Column(name="airplane_ID")
	int aId;
	
	@Column(name="departure_date")
	java.time.LocalDate dDate;
	
	@Column(name="departure_time")
	java.time.LocalTime dTime;
	
	@Column(name="arrival_date")
	java.time.LocalDate aDate;
	
	@Column(name="arrival_time")
	java.time.LocalTime aTime;
	
	@Column(name="departure_airport")
	String dAirport;
	
	@Column(name="arrival_airport")
	String aAirport;
	
	@Column(name="base_price")
	int bPrice;
	
	@Column(name="status")
	String status;

	public Flight() {
	}

	public Flight(int id, String airline, int aId, LocalDate dDate, LocalTime dTime, LocalDate aDate,
			LocalTime aTime, String dAirport, String aAirport, int bPrice, String status) {
		super();
		this.id = id;
		this.airline = airline;
		this.aId = aId;
		this.dDate = dDate;
		this.dTime = dTime;
		this.aDate = aDate;
		this.aTime = aTime;
		this.dAirport = dAirport;
		this.aAirport = aAirport;
		this.bPrice = bPrice;
		this.status = status;
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

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public java.time.LocalDate getdDate() {
		return dDate;
	}

	public void setdDate(java.time.LocalDate dDate) {
		this.dDate = dDate;
	}

	public java.time.LocalTime getdTime() {
		return dTime;
	}

	public void setdTime(java.time.LocalTime dTime) {
		this.dTime = dTime;
	}

	public java.time.LocalDate getaDate() {
		return aDate;
	}

	public void setaDate(java.time.LocalDate aDate) {
		this.aDate = aDate;
	}

	public java.time.LocalTime getaTime() {
		return aTime;
	}

	public void setaTime(java.time.LocalTime aTime) {
		this.aTime = aTime;
	}

	public String getdAirport() {
		return dAirport;
	}

	public void setdAirport(String dAirport) {
		this.dAirport = dAirport;
	}

	public String getaAirport() {
		return aAirport;
	}

	public void setaAirport(String aAirport) {
		this.aAirport = aAirport;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", aId=" + aId + ", dDate=" + dDate + ", dTime=" + dTime
				+ ", aDate=" + aDate + ", aTime=" + aTime + ", dAirport=" + dAirport + ", aAirport=" + aAirport
				+ ", bPrice=" + bPrice + ", status=" + status + "]";
	}
	

	

}
