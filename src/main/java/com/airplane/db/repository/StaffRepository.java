package com.airplane.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airplane.db.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, String>{

}
