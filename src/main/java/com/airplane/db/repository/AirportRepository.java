package com.airplane.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplane.db.entity.Agent;
import com.airplane.db.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, String>{

}
