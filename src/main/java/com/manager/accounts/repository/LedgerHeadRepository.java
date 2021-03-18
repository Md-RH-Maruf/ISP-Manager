package com.manager.accounts.repository;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manager.accounts.entity.LedgerHead;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Service;


@Repository
public interface LedgerHeadRepository extends JpaRepository<LedgerHead, Long>{
	public List<LedgerHead> findByParentId(Long parentId);
	public List<LedgerHead> findByOrderByParentIdAsc();
	public LedgerHead findByHeadName(String headName);
	public LedgerHead findByHeadNameAndIdNot(String head,long id);
	
}