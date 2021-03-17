package com.manager.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionProductDetails;

@Repository
public interface RequisitionProductDetailsRepository extends JpaRepository<RequisitionProductDetails, Long>{
	
	public List<RequisitionProductDetails> findByRequisitionNo(String requisitionNo);
	
	//public List<ProductRequisition> findByStatus(int status);
	
}
