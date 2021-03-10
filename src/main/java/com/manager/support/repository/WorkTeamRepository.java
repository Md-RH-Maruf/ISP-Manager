package com.manager.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.SupportTeam;
import com.manager.support.entity.WorkTeam;

@Repository
public interface WorkTeamRepository extends JpaRepository<WorkTeam, Long>{
	public List<WorkTeam> findByTicketId(String tmsNo);
}
