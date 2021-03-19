package com.manager.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.accounts.entity.Transaction;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionProductDetails;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	public List<Transaction> findByBillNo(String billNo);
	
	//public List<ProductRequisition> findByStatus(int status);
	
}
