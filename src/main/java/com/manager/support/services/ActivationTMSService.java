package com.manager.support.services;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.ActivationTMS;
import com.manager.support.repository.ActivationTMSRepository;

@Service
public class ActivationTMSService {
	@Autowired
	ActivationTMSRepository activationRepository;
	DecimalFormat df = new DecimalFormat("00");
	public String getMaxTMSNo() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "AT-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+activationRepository.getMaxTMSNo(yearMonth);
	}
	
	public ActivationTMS saveActivationTMS(ActivationTMS activationTms) {
		return activationRepository.save(activationTms);
	}
	
	public ActivationTMS getActivationTMS(long id) {
		return activationRepository.findById(id).orElse(null);
	}
}
