package com.manager.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.store.entity.ProductRequisition;

@Repository
public interface ProductRequisitionRepository extends JpaRepository<ProductRequisition, Long>{
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(requisition_no,11) AS signed )),0)+1) AS Id FROM tb_product_requisition WHERE requisition_no LIKE ?1%", nativeQuery = true)
	public String getMaxRequisitionNo(String yearMonth);
	
	public ProductRequisition findByRequisitionNo(String requisitionNo);
	
	public List<ProductRequisition> findByStatus(int status);
	
}
