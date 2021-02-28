package com.manager.support.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.ActivationTMS;
import com.manager.support.repository.ActivationTMSRepository;

@Service
public class ActivationTMSService {
	@Autowired
	ActivationTMSRepository activationRepository;
	
	public ActivationTMS saveActivationTMS(ActivationTMS activationTms) {
		return activationRepository.save(activationTms);
	}
	
	public ActivationTMS getActivationTMS(long id) {
		return activationRepository.findById(id).orElse(null);
	}
}
