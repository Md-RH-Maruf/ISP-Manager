package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.OltMcPosition;
import com.manager.support.repository.OltMcPositionRepository;

@Service
public class OltMcPositionService {
	@Autowired
	OltMcPositionRepository oltMcRepository;
	
	public OltMcPosition saveOltMcPosition(OltMcPosition oltMcPosition) {
		return oltMcRepository.save(oltMcPosition);
	}
	
	public OltMcPosition getOltMcPosition(String oltMcName) {
		return oltMcRepository.findByOltMcName(oltMcName);
	}
	
	public OltMcPosition getOltMcPosition(long id) {
		return oltMcRepository.findById(id).orElse(null);
	} 
	
	public List<OltMcPosition> getOltMcPositions(){
		return oltMcRepository.findAll();
	}
}
