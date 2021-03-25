package com.manager.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.accounts.entity.Bill;
import com.manager.store.entity.ProductRequisition;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	@Query(value = "SELECT (ifnull(max(cast(SUBSTRING(bill_no,10) AS signed )),0)+1) AS Id FROM tb_bills WHERE bill_no LIKE ?1%", nativeQuery = true)
	public String getMaxBillNo(String yearMonth);
	
	public Bill findByBillNo(String billNo);
	public List<Bill> findByBillTypeAndCustomerId(int billType,String customerId);
	public List<Bill> findByBillTypeAndStatus(int billType,int status);
	
	public List<Bill> findByStatus(int status);
	
	
	
}
