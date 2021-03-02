package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.OltInformation;

@Repository
public interface OltInfoRepository extends JpaRepository<OltInformation, Long>{
	public OltInformation findByOltName(String oltName);
}
