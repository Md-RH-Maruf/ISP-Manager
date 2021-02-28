package com.manager.support.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.ComplainTMS;
import com.manager.support.repository.ComplainTMSRepository;

@Service
public class ComplainTMSService {

	@Autowired
	ComplainTMSRepository complainRepository;
	
	public ComplainTMS saveComplainTMS(ComplainTMS complainTms) {
		return complainRepository.save(complainTms);
	}
	
	public ComplainTMS getComplainTMS(long id) {
		return complainRepository.findById(id).orElse(null);
	}
}
