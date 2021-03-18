package com.manager.accounts.repository;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.accounts.entity.Ledger;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Service;
import com.manager.store.entity.Category;


@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long>{
	public List<Ledger> findByHeadId(Long headId);
	public List<Ledger> findByActiveStatus(int activeStatus);
	public Ledger findByLedgerName(String productName);
	public Ledger findByLedgerNameAndIdNot(String productName,long id);
	
	
}