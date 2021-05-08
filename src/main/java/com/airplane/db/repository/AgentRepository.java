package com.airplane.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplane.db.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, String>{

}
