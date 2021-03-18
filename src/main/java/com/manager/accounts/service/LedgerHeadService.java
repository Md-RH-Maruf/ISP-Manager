package com.manager.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.accounts.entity.LedgerHead;
import com.manager.accounts.repository.LedgerHeadRepository;



@Service
public class LedgerHeadService {
	
	@Autowired
	LedgerHeadRepository ledgerHeadRepo;
	
	public LedgerHead saveLedgerHead(LedgerHead ledgerHead) {
		
		return ledgerHeadRepo.save(ledgerHead);
	}
	
	public LedgerHead findByHeadName(String headName) {
		return ledgerHeadRepo.findByHeadName(headName);
	}
	
	public List<LedgerHead> findByParentId(String parentId) {
		return ledgerHeadRepo.findByParentId(Long.valueOf(parentId));
	}
	
	public List<LedgerHead> getLedgerHeadListOrderByParentId(){
		return ledgerHeadRepo.findByOrderByParentIdAsc();
	}
	
	public List<LedgerHead> getLedgerHeadList(){
		return ledgerHeadRepo.findAll();
	}
	
	public LedgerHead findById(long id) {
		return ledgerHeadRepo.findById(id).orElse(null);
	}
	
	public boolean isLedgerHeadExist(String ledgerHeadName,long id) {
		if(ledgerHeadRepo.findByHeadNameAndIdNot(ledgerHeadName, id) != null) {
			return true;
		}
		
		return false;
	}
}
