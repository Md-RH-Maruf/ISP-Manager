package com.manager.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.ComplainTMS;

@Repository
public interface ComplainTMSRepository extends JpaRepository<ComplainTMS, Long>{
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(tms_no,10) AS signed )),0)+1) AS Id FROM tb_complain_tms WHERE tms_no LIKE ?1%", nativeQuery = true)
	public String getMaxTMSNo(String yearMonth);
	
	public ComplainTMS findByTmsNo(String tmsNo);
	
	public List<ComplainTMS> findByProblemType(String problemType);
	
	public List<ComplainTMS> findByCustomerId(String customerId);
}
