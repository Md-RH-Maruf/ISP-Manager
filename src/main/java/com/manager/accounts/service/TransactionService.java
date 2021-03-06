package com.manager.accounts.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.accounts.entity.Ledger;
import com.manager.accounts.entity.Transaction;
import com.manager.accounts.entity.TransactionInfo;
import com.manager.accounts.repository.TransactionRepository;
import com.manager.security.entity.User;
import com.manager.store.entity.Product;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionInfo;
import com.manager.store.entity.RequisitionProduct;
import com.manager.store.entity.RequisitionProductDetails;

@Service
public class TransactionService {

	DecimalFormat df = new DecimalFormat("00");
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	@Autowired
	TransactionRepository transactionRepo;
	
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}
	
	public List<Transaction> saveTransactions(List<Transaction> transactions) {
		return transactionRepo.saveAll(transactions);
	}
	
	
	public List<Transaction> findByBillNo(String billNo) {
		return transactionRepo.findByBillNo(billNo);
	}
	
	
	public List<Transaction> getTransactionList(){
		return transactionRepo.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TransactionInfo> getTransactionInfoListByBillNo(String billNo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<TransactionInfo> requistionList = new ArrayList<TransactionInfo>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT t,dl,cl \r\n" 
				+ "FROM Transaction t\r\n" + 
				"LEFT JOIN Ledger dl \r\n"+
				"ON t.debitLedger = dl.id \r\n"+
				"LEFT JOIN Ledger cl \r\n"+
				"ON t.creditLedger = cl.id \r\n"+
				"WHERE t.billNo = '"+billNo+"'").getResultList();
		
		
		for(Object[] obj:results) {
			Transaction t = (Transaction)obj[0];
			Ledger dl = (Ledger)obj[1];
			Ledger cl = (Ledger)obj[2];
			
			if(t != null) {
				TransactionInfo ti = new TransactionInfo();
				ti.setId(t.getId());
				ti.setBillNo(t.getBillNo());
				ti.setStatus(t.getStatus());
				ti.setTransactionType(t.getTransactionType());
				if(dl != null) { ti.setDebitLedger(dl.getLedgerName());
					ti.setDebitLedgerId(t.getDebitLedger());
				}
				if(cl != null) {ti.setCreditLedger(cl.getLedgerName());
					ti.setCreditLedgerId(t.getCreditLedger());
				}
				ti.setDescription(t.getDescription());
				ti.setAmount(t.getAmount());
				requistionList.add(ti);
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return requistionList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RequisitionInfo> getTransactionListByLedgerId(String status){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<RequisitionInfo> requistionList = new ArrayList<RequisitionInfo>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT pr,\r\n" + 
				"(SELECT SUM(rpd.productQuantity) FROM RequisitionProductDetails rpd WHERE rpd.requisitionNo = pr.requisitionNo) AS productQuantity,u \r\n"
				+ "FROM ProductRequisition pr\r\n" + 
				"JOIN User u\r\n" + 
				"ON pr.entryBy = u.id\r\n" + 
				"WHERE pr.status = '"+status+"'").getResultList();
		
		for(Object[] obj:results) {
			ProductRequisition pr = (ProductRequisition)obj[0];
			long quantity = (long)obj[1];
			User user = (User)obj[2];
			
			if(pr != null) {
				
				requistionList.add(new RequisitionInfo((long) pr.getId(), pr.getRequisitionNo(), pr.getRequisitionDate().toString(), pr.getTicketId(), quantity, user.getUsername()));
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return requistionList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RequisitionProduct> getTransactions(String billNo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<RequisitionProduct> productList = new ArrayList<RequisitionProduct>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT rpd,p FROM RequisitionProductDetails rpd \r\n"
				+ "join Product p on rpd.productId = p.id \r\n"
				+ "WHERE rpd.requisitionNo = '"+billNo+"'").getResultList();
		
		for(Object[] obj:results) {
			RequisitionProductDetails rpd = (RequisitionProductDetails)obj[0];
			
			Product p = (Product)obj[1];
			
			if(rpd != null) {
				productList.add(new RequisitionProduct((long)rpd.getId(), billNo, String.valueOf(rpd.getProductId()), p.getProductName(), (long)rpd.getProductQuantity(), rpd.getDescription()));
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return productList;
		
	}
}
