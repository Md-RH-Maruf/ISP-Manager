package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.PPPoEInfo;
import com.manager.support.repository.McInfoRepository;
import com.manager.support.repository.PPPoERepository;

@Service
public class PPPoEService {

	@Autowired
	PPPoERepository pppoeRepo;
	
	public PPPoEInfo savePPPoEInfo(PPPoEInfo ppoeInfo) {
		return pppoeRepo.save(ppoeInfo);
	}
	
	public PPPoEInfo getMcInformation(long id) {
		return pppoeRepo.findById(id).orElse(null);
	}
	
	public List<PPPoEInfo> getPPPoEList(){
		return pppoeRepo.findAll();
	}
}
