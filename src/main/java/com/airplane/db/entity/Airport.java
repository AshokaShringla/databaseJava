package com.airplane.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {

	@Id
	@Column(name="name")
	String name;
	
	@Column(name="city")
	String city;

	public Airport() {
		super();
	}

	public Airport(String name, String city) {
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
		return "Airport [name=" + name + ", city=" + city + "]";
	}
}
