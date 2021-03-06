package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.ActivationTMS;
@Repository
public interface ActivationTMSRepository extends JpaRepository<ActivationTMS, Long>{
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(tms_no,10) AS signed )),0)+1) AS Id FROM tb_activation_tms WHERE tms_no LIKE ?1%", nativeQuery = true)
	public String getMaxTMSNo(String yearMonth);
}
