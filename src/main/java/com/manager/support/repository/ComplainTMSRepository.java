package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.ComplainTMS;

@Repository
public interface ComplainTMSRepository extends JpaRepository<ComplainTMS, Long>{
	
}
