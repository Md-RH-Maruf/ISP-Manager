package com.manager.support.services;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.example.entityModel.TicketDetails;
import com.manager.inventory.entity.Customer;
import com.manager.inventory.entity.Employee;
import com.manager.security.entity.ResourceRoleDetails;
import com.manager.security.entity.User;
import com.manager.support.entity.ActivationTMS;
import com.manager.support.repository.ActivationTMSRepository;

@Service
public class ActivationTMSService {
	@Autowired
	ActivationTMSRepository activationRepository;
	DecimalFormat df = new DecimalFormat("00");
	
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	public String getMaxTMSNo() {
		LocalDate currentdate = LocalDate.now();
		String yearMonth = "AT-"+currentdate.getYear()+""+df.format(currentdate.getMonthValue());
		return yearMonth+activationRepository.getMaxTMSNo(yearMonth);
	}
	
	public ActivationTMS saveActivationTMS(ActivationTMS activationTms) {
		return activationRepository.save(activationTms);
	}
	
	public ActivationTMS getActivationTMSByTmsNo(String tmsNo) {
		return activationRepository.findByTmsNo(tmsNo);
	}
	
	public ActivationTMS getActivationTMS(long id) {
		return activationRepository.findById(id).orElse(null);
	}
	
	public void deleteActivationTMS(ActivationTMS activationTms) {
		activationRepository.delete(activationTms);;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TicketDetails> getTicketListByStatus(String status){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<TicketDetails> ticketList = new ArrayList<>();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT tat,c,lfu,emp \r\n" + 
				"FROM ActivationTMS tat \r\n" + 
				"LEFT JOIN Customer c\r\n" + 
				"on tat.customerId = c.customerId\r\n"
				+ "LEFT JOIN User lfu\r\n" + 
				"ON tat.lastFollowupBy = lfu.id\r\n" +
				"LEFT OUTER JOIN Employee emp\r\n" + 
				"ON tat.owner = emp.id\r\n" +
				"WHERE tat.status = '"+status+"'").getResultList();
		
		for(Object[] obj:results) {
			ActivationTMS tms = (ActivationTMS)obj[0];
			Customer customer = (Customer)obj[1];
			User lastFollowUpUser = (User)obj[2];
			Employee emp = (Employee)obj[3];
			
			if(emp == null) {
				emp = new Employee();
				emp.setFirstName("");
				emp.setLastName("");
			}
			ticketList.add(new TicketDetails(tms.getId(), tms.getTmsNo(), tms.getCustomerId(), tms.getSubject(), customer.getArea(), tms.getStatus(), tms.getPriority(), tms.getEntryTime().toString(), lastFollowUpUser.getUsername(), tms.getLastFollowupTime().toString(), emp.getFirstName()+" "+emp.getLastName()));
		}
		em.getTransaction().commit();
		em.close();
		return ticketList;
		
	}
}
