package com.manager.inventory.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.manager.inventory.entity.Reseller;
import com.manager.inventory.repository.ResellerRepository;

@Service
public class ResellerService {
	
	@Autowired
	ResellerRepository resellerRepo;
	DecimalFormat df = new DecimalFormat("00");
	public String getMaxResellerId() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "RS-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+resellerRepo.findResellerId(yearMonth);
	}
	
	public Reseller saveReseller(Reseller reseller) {
		
		return resellerRepo.save(reseller);
	}

	public Reseller findById(Long id) {
		return resellerRepo.findById(id).orElse(null);
	}
	
	public Reseller findByResellerId(String resellerId) {
		return resellerRepo.findByResellerId(resellerId);
	}
	
	public List<Reseller> getResellerList(){
		return resellerRepo.findAll();
	}
}
