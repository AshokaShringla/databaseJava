package com.airplane.db.service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airplane.db.dto.PaymentDTO;
import com.airplane.db.entity.Payment;
import com.airplane.db.repository.PaymentRepository;

@Service ("PaymentService")
public class PaymentServiceImpl implements PaymentService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	PaymentRepository paymentRepository;

	
	@Override
	@Transactional
	public PaymentDTO addPayment(PaymentDTO payment) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		Payment paymentEntity = modelMapper.map(payment, Payment.class);
		
		
		paymentRepository.save(paymentEntity);
		paymentRepository.flush();
		return getPaymentDTO(paymentEntity);
		
	}
	
	
	
	private PaymentDTO getPaymentDTO(final Payment payment) {
		
		PaymentDTO payment1 = new PaymentDTO();
		
		payment1.setId(payment.getId());
		payment1.setCardType(payment.getCardType());
		payment1.setCardNumber(payment.getCardNumber());
		payment1.setExpDate(payment.getExpDate());
		payment1.setName(payment.getName());
		
		return payment1;
		
	}

}
