package com.airplane.db.service;

import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.airplane.db.entity.Agent;
import com.airplane.db.entity.Customer;
import com.airplane.db.entity.Payment;
import com.airplane.db.entity.Staff;
import com.airplane.db.repository.AgentRepository;
import com.airplane.db.repository.CustomerRepository;
import com.airplane.db.repository.StaffRepository;
import com.airplane.db.dto.AgentDTO;
import com.airplane.db.dto.CustomerDTO;
import com.airplane.db.dto.StaffDTO;

@Service ("CustomerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public CustomerDTO returnCustomer (String email, String password) {
		
		try {
		CustomerDTO customer1 = getCustomerDTO(customerRepository.findById(email).get());
		if(BCrypt.checkpw(customer1.getPassword(), password)) {
			return customer1;
		}
		else {
			return null;
		}
		}
		catch(NoSuchElementException ex) {
			return null;
		}
		

	}
	
	@Override
	public CustomerDTO returnCustomer1(CustomerDTO customer) {
		
		try {
		CustomerDTO customer1 = getCustomerDTO(customerRepository.findById(customer.getCustomerEmail()).get());
		if(BCrypt.checkpw(customer.getPassword(), customer1.getPassword())) {
			return customer1;
		}
		else {
			return null;
		}
		}
		catch(NoSuchElementException ex) {
			return null;
		}
		
	}
	
	@Override
	public CustomerDTO register(CustomerDTO customer) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Customer customerEntity = modelMapper.map(customer, Customer.class);
		
		customerEntity.setPassword(BCrypt.hashpw(customerEntity.getPassword(), BCrypt.gensalt()));
		
		customerRepository.saveAndFlush(customerEntity);
		
		return getCustomerDTO(customerEntity);
		
	}
	
	@Override
	public AgentDTO returnAgent(AgentDTO agent) {
		try {
		AgentDTO agent1 = getAgentDTO(agentRepository.findById(agent.getEmail()).get());
		
		if(BCrypt.checkpw(agent.getPassword(), agent1.getPassword())  && agent1.getId() == agent.getId()) {
			return agent1;
		}
		else {
			return null;
		}
		}
	catch(NoSuchElementException ex) {
		return null;
	}
		

	}
	
	@Override
	public AgentDTO registerAgent(AgentDTO agent) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Agent agentEntity = modelMapper.map(agent, Agent.class);
		agentEntity.setPassword(BCrypt.hashpw(agentEntity.getPassword(), BCrypt.gensalt()));
		agentRepository.saveAndFlush(agentEntity);
		return getAgentDTO(agentEntity);
		
	}
	
	@Override
	public StaffDTO returnStaff(StaffDTO staff) {
		try {
		StaffDTO staff1 = getStaffDTO(staffRepository.findById(staff.getUsername()).get());
		
		if(BCrypt.checkpw(staff.getPassword(), staff1.getPassword())) {
			return staff1;
		}
		else {
			return null;
		}
		
		}
		catch(NoSuchElementException ex) {
			return null;
		}

	}
	
	@Override
	public StaffDTO registerStaff(StaffDTO staff) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Staff staffEntity = modelMapper.map(staff, Staff.class);
		staffEntity.setPassword(BCrypt.hashpw(staffEntity.getPassword(), BCrypt.gensalt()));
		staffRepository.saveAndFlush(staffEntity);
		return getStaffDTO(staffEntity);
		
	}
	
	
	private CustomerDTO getCustomerDTO(final Customer customer) {
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerEmail(customer.getCustomerEmail());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setName(customer.getName());
		customerDTO.setBuildingNumber(customer.getBuildingNumber());
		customerDTO.setStreet(customer.getStreet());
		customerDTO.setCity(customer.getCity());
		customerDTO.setState(customer.getState());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setPassportNumber(customer.getPassportNumber());
		customerDTO.setPassportExpiration(customer.getPassportExpiration());
		customerDTO.setPassportCountry(customer.getPassportCountry());
		customerDTO.setDateBirth(customer.getDateBirth());

		return customerDTO;		
		
	}
	
	private AgentDTO getAgentDTO(final Agent agent) {
		AgentDTO agentDTO = new AgentDTO();
		
		agentDTO.setEmail(agent.getEmail());
		agentDTO.setPassword(agent.getPassword());
		agentDTO.setId(agent.getId());
		
		return agentDTO;
	}
	
	private StaffDTO getStaffDTO(final Staff staff) {
		StaffDTO staffDTO = new StaffDTO();
		
		staffDTO.setAirline(staff.getAirline());
		staffDTO.setDateBirth(staff.getDateBirth());
		staffDTO.setFname(staff.getFname());
		staffDTO.setLname(staff.getLname());
		staffDTO.setPassword(staff.getPassword());
		staffDTO.setUsername(staff.getUsername());
		
		return staffDTO;
	}


}
