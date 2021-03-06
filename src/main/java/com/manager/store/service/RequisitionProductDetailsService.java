package com.manager.store.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.security.entity.User;
import com.manager.store.entity.Product;
import com.manager.store.entity.ProductRequisition;
import com.manager.store.entity.RequisitionInfo;
import com.manager.store.entity.RequisitionProduct;
import com.manager.store.entity.RequisitionProductDetails;
import com.manager.store.repository.ProductRequisitionRepository;
import com.manager.store.repository.RequisitionProductDetailsRepository;

@Service
public class RequisitionProductDetailsService {

	DecimalFormat df = new DecimalFormat("00");
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	@Autowired
	RequisitionProductDetailsRepository requiPrductRepo;
	
	public RequisitionProductDetails saveRequisitionProduct(RequisitionProductDetails requisitionProduct) {
		return requiPrductRepo.save(requisitionProduct);
	}
	
	public List<RequisitionProductDetails> saveRequisitionProducts(List<RequisitionProductDetails> requisitionProducts) {
		return requiPrductRepo.saveAll(requisitionProducts);
	}
	
	
	public List<RequisitionProductDetails> findByRequisitionNo(String requisitionNo) {
		return requiPrductRepo.findByRequisitionNo(requisitionNo);
	}
	
	
	public List<RequisitionProductDetails> getProductRequisitionList(){
		return requiPrductRepo.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RequisitionInfo> getProductRequisitionListByStatus(String status){
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
				JSONObject object = new JSONObject();
				object.put("requisitionNo", pr.getRequisitionNo());
				object.put("requisitionDate", pr.getRequisitionDate());
				object.put("ticketId", pr.getTicketId());
				object.put("productQuantity", quantity);
				object.put("createdBy", user.getUsername());
				requistionList.add(new RequisitionInfo((long) pr.getId(), pr.getRequisitionNo(), pr.getRequisitionDate().toString(), pr.getTicketId(), quantity, user.getUsername()));
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return requistionList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RequisitionProduct> getRequisitionProducts(String requisitionNo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<RequisitionProduct> productList = new ArrayList<RequisitionProduct>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT rpd,p FROM RequisitionProductDetails rpd \r\n"
				+ "join Product p on rpd.productId = p.id \r\n"
				+ "WHERE rpd.requisitionNo = '"+requisitionNo+"'").getResultList();
		
		for(Object[] obj:results) {
			RequisitionProductDetails rpd = (RequisitionProductDetails)obj[0];
			
			Product p = (Product)obj[1];
			
			if(rpd != null) {
				
				productList.add(new RequisitionProduct((long)rpd.getId(), requisitionNo, String.valueOf(rpd.getProductId()), p.getProductName(), (long)rpd.getProductQuantity(), rpd.getDescription()));
			}
			
		}
		em.getTransaction().commit();
		em.close();
		return productList;
		
	}
}
