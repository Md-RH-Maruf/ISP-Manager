package com.manager.accounts.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.accounts.entity.Bill;
import com.manager.accounts.entity.BillInfo;
import com.manager.accounts.entity.Ledger;
import com.manager.accounts.entity.Transaction;
import com.manager.accounts.repository.BillRepository;
import com.manager.example.entityModel.TicketDetails;
import com.manager.example.shareModel.BillType;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Employee;
import com.manager.security.entity.User;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionInfo;
import com.manager.store.repository.ProductRequisitionRepository;
import com.manager.support.entity.ActivationTMS;

@Service
public class BillService {

	DecimalFormat df = new DecimalFormat("00");
	SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MMM-yyyy");
	SimpleDateFormat dateTimeFormate = new SimpleDateFormat("dd-MMM-yyyy HH:MM");
	
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	BillRepository billRepo;
	
	public String getMaxBillNo() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "BN-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+billRepo.getMaxBillNo(yearMonth);
	}
	
	public Bill saveBill(Bill bill) {
		return billRepo.save(bill);
	}
	
	public Bill findById(long id) {
		return billRepo.findById(id).orElse(null);
	}
	
	public Bill findByBillNo(String billNo) {
		return billRepo.findByBillNo(billNo);
	}
	
	public List<Bill> getBillList(){
		return billRepo.findAll();
	}
	
	public List<Bill> getBillsByStatus(String status){
		return billRepo.findByStatus(Integer.valueOf(status));
	}
	
	public List<Bill> getBillsBillTypeAndCustomerId(int billType,String customerId){
		return billRepo.findByBillTypeAndCustomerId(billType, customerId);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<BillInfo> getBillsByBillTypeAndStatus(int billType,int status){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<BillInfo> billList = new ArrayList<BillInfo>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT bill,t,u,approveU,rejectU,dl,cl \r\n" 
				+ "FROM Bill bill\r\n" + 
				"JOIN Transaction t\r\n" + 
				"ON bill.billNo = t.billNo\r\n" +
				"LEFT JOIN User u\r\n" + 
				"ON bill.entryBy = u.id\r\n" +
				"LEFT JOIN User approveU\r\n" + 
				"ON bill.approveBy = approveU.id\r\n" + 
				"LEFT JOIN User rejectU\r\n" + 
				"ON bill.rejectedBy = rejectU.id\r\n" + 
				"LEFT JOIN Ledger dl \r\n"+
				"ON t.debitLedger = dl.id \r\n"+
				"LEFT JOIN Ledger cl \r\n"+
				"ON t.creditLedger = cl.id \r\n"+
				"WHERE bill.status = '"+status+"' and bill.billType = '"+billType+"'").getResultList();
		
		for(Object[] obj:results) {
			Bill bill = (Bill)obj[0];
			Transaction t = (Transaction)obj[1];
			User user = (User)obj[2];
			User approveUser = (User)obj[3];
			User rejectU = (User)obj[4];
			Ledger dl = (Ledger)obj[5];
			Ledger cl = (Ledger)obj[6];
			if(bill != null) {
				BillInfo billInfo = new BillInfo();
				
				billInfo.setId(t.getId());
				billInfo.setBillNo(bill.getBillNo());
				billInfo.setBillDate(dateFormate.format(bill.getBillDate().getTime()));
				billInfo.setTicketId(bill.getTicketId());
				billInfo.setCreatedBy(user.getUsername());
				billInfo.setDescription(t.getDescription());
				billInfo.setTotalAmount(bill.getTotalAmount());
				billInfo.setApproveAmount(bill.getApproveAmount());
				billInfo.setRejectedCause(bill.getRejectedCause());
				if(approveUser != null) {
					billInfo.setApprovedBy(approveUser.getUsername());
					billInfo.setApprovedDate(dateFormate.format(bill.getApproveDate()));
				}
				if(rejectU != null) {
					billInfo.setRejectedBy(rejectU.getUsername());
					billInfo.setRejectedDate(dateFormate.format(bill.getRejectedDate()));
				}
				
				if(bill.getBillType()== BillType.Cash_Payment.getType()) {
					billInfo.setBillHead(dl.getLedgerName());
				}else if(bill.getBillType() == BillType.Cash_Received.getType()) {
					billInfo.setBillHead(cl.getLedgerName());
				}else if(bill.getBillType() == BillType.Create_Bill.getType()) {
					billInfo.setBillHead(dl.getLedgerName());
				}
				
				billList.add(billInfo);
				
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return billList;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<BillInfo> getBillListByStatus(String status){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<BillInfo> billList = new ArrayList<BillInfo>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT bill,t,u,issueU,approveU \r\n" 
				+ "FROM Bill bill\r\n" + 
				"JOIN Transaction t\r\n" + 
				"ON bill.billNo = u.id\r\n" + 
				"LEFT JOIN User issueU\r\n" + 
				"ON bill.issuedBy = issueU.id\r\n" + 
				"LEFT JOIN User approveU\r\n" + 
				"ON bill.approvedBy = approveU.id\r\n" + 
				"WHERE bill.status = '"+status+"'").getResultList();
		
		for(Object[] obj:results) {
			Bill pr = (Bill)obj[0];
			Transaction transaction = (Transaction)obj[1];
			User user = (User)obj[2];
			User issueUser = (User)obj[3];
			User approveUser = (User)obj[4];
			if(pr != null) {
				BillInfo requisitionInfo = new BillInfo();
				if(issueUser != null) {
					//requisitionInfo.setIssuedBy(issueUser.getUsername());
					//requisitionInfo.setIssuedDate(pr.getIssuedDate());
				}
				if(approveUser != null) {
					requisitionInfo.setApprovedBy(approveUser.getUsername());
					//requisitionInfo.setApprovedDate(pr.getApprovedDate());
				}
				billList.add(requisitionInfo);
				
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return billList;
		
	}
}
