package com.manager.store.service;

import java.text.DecimalFormat;
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

import com.manager.example.entityModel.TicketDetails;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Employee;
import com.manager.security.entity.User;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionInfo;
import com.manager.store.repository.ProductRequisitionRepository;
import com.manager.support.entity.ActivationTMS;

@Service
public class ProductRequisitionService {

	DecimalFormat df = new DecimalFormat("00");
	
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ProductRequisitionRepository productReqRepo;
	
	public String getMaxRequisitionNo() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "PRQ-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+productReqRepo.getMaxRequisitionNo(yearMonth);
	}
	
	public ProductRequisition saveProductRequisition(ProductRequisition productRequisition) {
		return productReqRepo.save(productRequisition);
	}
	
	public ProductRequisition findById(long id) {
		return productReqRepo.findById(id).orElse(null);
	}
	
	public ProductRequisition findByRequisitionNo(String requisitionNo) {
		return productReqRepo.findByRequisitionNo(requisitionNo);
	}
	
	public List<ProductRequisition> getProductRequisitionList(){
		return productReqRepo.findAll();
	}
	
	public List<ProductRequisition> getProductRequisitionsByStatus(String status){
		return productReqRepo.findByStatus(Integer.valueOf(status));
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RequisitionInfo> getProductRequisitionListByStatus(String status){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<RequisitionInfo> requistionList = new ArrayList<RequisitionInfo>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT pr,\r\n" + 
				"(SELECT SUM(rpd.productQuantity) FROM RequisitionProductDetails rpd WHERE rpd.requisitionNo = pr.requisitionNo) AS productQuantity,u,issueU,approveU \r\n"
				+ "FROM ProductRequisition pr\r\n" + 
				"JOIN User u\r\n" + 
				"ON pr.entryBy = u.id\r\n" + 
				"LEFT JOIN User issueU\r\n" + 
				"ON pr.issuedBy = issueU.id\r\n" + 
				"LEFT JOIN User approveU\r\n" + 
				"ON pr.approvedBy = approveU.id\r\n" + 
				"WHERE pr.status = '"+status+"'").getResultList();
		
		for(Object[] obj:results) {
			ProductRequisition pr = (ProductRequisition)obj[0];
			long quantity = (long)obj[1];
			User user = (User)obj[2];
			User issueUser = (User)obj[3];
			User approveUser = (User)obj[4];
			if(pr != null) {
				RequisitionInfo requisitionInfo = new RequisitionInfo((long) pr.getId(), pr.getRequisitionNo(), pr.getRequisitionDate().toString(), pr.getTicketId(), quantity, user.getUsername());
				if(issueUser != null) {
					requisitionInfo.setIssuedBy(issueUser.getUsername());
					requisitionInfo.setIssuedDate(pr.getIssuedDate());
				}
				if(approveUser != null) {
					requisitionInfo.setApprovedBy(approveUser.getUsername());
					requisitionInfo.setApprovedDate(pr.getApprovedDate());
				}
				requistionList.add(requisitionInfo);
				
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return requistionList;
		
	}
}
