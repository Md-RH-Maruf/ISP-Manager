package com.manager.inventory.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.inventory.entity.Reseller;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller, Long>{
	public Reseller findByResellerId(String resellerId);
	
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(reseller_Id,10) AS signed )),0)+1) AS Id FROM Reseller WHERE reseller_Id LIKE ?1%", nativeQuery = true)
	public String findResellerId(String yearMonth);
}
