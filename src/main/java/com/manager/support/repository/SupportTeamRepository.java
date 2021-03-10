package com.manager.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.SupportTeam;

@Repository
public interface SupportTeamRepository extends JpaRepository<SupportTeam, Long>{
	public List<SupportTeam> findByTicketId(String tmsNo);
}
