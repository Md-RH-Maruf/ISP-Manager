package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.OltMcPosition;

@Repository
public interface OltMcPositionRepository extends JpaRepository<OltMcPosition, Long>{
	public OltMcPosition findByOltMcName(String oltMcName);
}
