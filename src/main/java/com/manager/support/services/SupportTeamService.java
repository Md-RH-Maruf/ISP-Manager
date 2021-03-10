package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.SupportTeam;
import com.manager.support.entity.WorkTeam;
import com.manager.support.repository.McInfoRepository;
import com.manager.support.repository.SupportTeamRepository;
import com.manager.support.repository.WorkTeamRepository;

@Service
public class SupportTeamService {

	@Autowired
	SupportTeamRepository supportTeamRepo;
	
	public SupportTeam saveSupportTeam(SupportTeam supportTeam) {
		return supportTeamRepo.save(supportTeam);
	}
	
	public SupportTeam getSupportTeam(long id) {
		return supportTeamRepo.findById(id).orElse(null);
	}
	
	public List<SupportTeam> getSupportTeamsByTmsNo(String tmsNo){
		return supportTeamRepo.findByTicketId(tmsNo);
	}
}
