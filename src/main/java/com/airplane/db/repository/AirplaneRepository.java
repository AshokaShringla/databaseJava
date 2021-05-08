package com.airplane.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.airplane.db.entity.Agent;
import com.airplane.db.entity.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, String>, JpaSpecificationExecutor<Airplane>{

}
