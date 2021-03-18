package com.manager.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.accounts.entity.Ledger;
import com.manager.accounts.repository.LedgerRepository;


@Service
public class LedgerService {
	
	@Autowired
	LedgerRepository ledgerRepo;
	
	public Ledger saveLedger(Ledger ledger) {
		
		return ledgerRepo.save(ledger);
	}
	
	public Ledger findByLedgerName(String ledgerName) {
		return ledgerRepo.findByLedgerName(ledgerName);
	}
	
	public List<Ledger> findByHeadId(String headId) {
		return ledgerRepo.findByHeadId(Long.valueOf(headId));
	}
	
	public List<Ledger> getLedgerListByActiveStatus(String activeStatus){
		return ledgerRepo.findByActiveStatus(Integer.valueOf(activeStatus));
	}
	
	public List<Ledger> getLedgerList(){
		return ledgerRepo.findAll();
	}
	
	public Ledger findById(long id) {
		return ledgerRepo.findById(id).orElse(null);
	}
	
	public boolean isLedgerExist(String ledgerName,long id) {
		if(ledgerRepo.findByLedgerNameAndIdNot(ledgerName, id) != null) {
			return true;
		}
		
		return false;
	}
}
