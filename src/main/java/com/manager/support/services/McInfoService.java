package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.McInformation;
import com.manager.support.repository.McInfoRepository;

@Service
public class McInfoService {

	@Autowired
	McInfoRepository mcInfoRepo;
	
	public McInformation saveMcInformation(McInformation mcInformation) {
		return mcInfoRepo.save(mcInformation);
	}
	
	public McInformation getMcInformation(long id) {
		return mcInfoRepo.findById(id).orElse(null);
	}
	
	public List<McInformation> getMcInformations(){
		return mcInfoRepo.findAll();
	}
}
