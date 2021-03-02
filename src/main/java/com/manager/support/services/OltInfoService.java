package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.OltInformation;
import com.manager.support.repository.OltInfoRepository;

@Service
public class OltInfoService {
	@Autowired
	OltInfoRepository oltInfoRepository;
	
	public OltInformation saveOltInformation(OltInformation oltMcPosition) {
		return oltInfoRepository.save(oltMcPosition);
	}
	
	public OltInformation getOltInfo(String oltName) {
		return oltInfoRepository.findByOltName(oltName);
	}
	
	public OltInformation getOltInformation(long id) {
		return oltInfoRepository.findById(id).orElse(null);
	} 
	
	public List<OltInformation> getOltInformations(){
		return oltInfoRepository.findAll();
	}
}
