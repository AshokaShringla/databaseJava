package com.airplane.db.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplane.db.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{

}
