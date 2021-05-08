package com.airplane.db.dto;

import javax.persistence.Column;

public class AirportDTO {
	
	String name;

	String city;

	public AirportDTO() {
		super();
	}

	public AirportDTO(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AirportDTO [name=" + name + ", city=" + city + "]";
	}

}
