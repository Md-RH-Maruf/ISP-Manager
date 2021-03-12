package com.manager.support.services;

import java.text.DecimalFormat;
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
import com.manager.support.entity.ActivationTMS;
import com.manager.support.entity.McInformation;
import com.manager.support.entity.PPPoEDetails;
import com.manager.support.entity.PPPoEInfo;
import com.manager.support.repository.McInfoRepository;
import com.manager.support.repository.PPPoERepository;

@Service
public class PPPoEService {
	
	
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;

	@Autowired
	PPPoERepository pppoeRepo;
	
	public PPPoEInfo savePPPoEInfo(PPPoEInfo ppoeInfo) {
		return pppoeRepo.save(ppoeInfo);
	}
	
	public PPPoEInfo getPPPoEInfo(long id) {
		return pppoeRepo.findById(id).orElse(null);
	}
	
	public PPPoEInfo getPPPoEInfoByCusteomerId(String customerId) {
		return pppoeRepo.findByCustomerId(customerId);
	}
	
	public List<PPPoEInfo> getPPPoEList(){
		return pppoeRepo.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<PPPoEDetails> getPPPoEIdPasswordList(){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<PPPoEDetails> list = new ArrayList();
		//SELECT tat.id,tat.tmsNo,tat.customerId,tat.subject,c.area,tat.status,tat.priority,tat.entryTime AS date,lfu.username AS followupBy,tat.lastFollowupTime,:emp.firstName  '' as firstNames
		List<Object[]> results = em.createQuery("SELECT ppp,c \r\n" + 
				"FROM PPPoEInfo ppp \r\n" + 
				"JOIN Customer c\r\n" + 
				"on ppp.customerId = c.customerId AND c.activeStatus=1").getResultList();
		PPPoEDetails object;
		for(Object[] obj:results) {
			PPPoEInfo ppp = (PPPoEInfo)obj[0];
			Customer customer = (Customer)obj[1];
			object = new PPPoEDetails();
			object.setId(ppp.getId().toString());
			object.setCustomerId(ppp.getCustomerId());
			object.setCustomerName(customer.getName());
			object.setPppoeId(ppp.getPppoeId());
			object.setPppoePassword(ppp.getPassword());
			list.add(object);
			
		}
		em.getTransaction().commit();
		em.close();
		return list;
		
	}
}
