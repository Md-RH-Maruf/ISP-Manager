package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.McInformation;
import com.manager.support.entity.PPPoEInfo;

@Repository
public interface PPPoERepository extends JpaRepository<PPPoEInfo, Long>{
	public PPPoEInfo findByCustomerId(String customerId);
}
