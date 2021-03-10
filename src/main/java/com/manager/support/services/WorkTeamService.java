package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.WorkTeam;
import com.manager.support.repository.McInfoRepository;
import com.manager.support.repository.WorkTeamRepository;

@Service
public class WorkTeamService {

	@Autowired
	WorkTeamRepository workTeamRepo;
	
	public WorkTeam saveWorkTeam(WorkTeam workTeam) {
		return workTeamRepo.save(workTeam);
	}
	
	public WorkTeam getWorkTeam(long id) {
		return workTeamRepo.findById(id).orElse(null);
	}
	
	public List<WorkTeam> getWorkTeamsByTmsNo(String tmsNo){
		return workTeamRepo.findByTicketId(tmsNo);
	}
}
