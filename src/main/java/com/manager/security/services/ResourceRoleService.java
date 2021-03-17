package com.manager.security.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.security.entity.ResourceRole;
import com.manager.security.entity.ResourceRoleDetails;
import com.manager.security.repository.ResourceRoleRepository;

@Service
public class ResourceRoleService {

	@Autowired
	ResourceRoleRepository resourceRoleRepo;
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	public ResourceRole saveResourceRole(ResourceRole resourceRole) {
		return resourceRoleRepo.save(resourceRole);
	}
	
	public void deleteById(Long id){
		try {
			resourceRoleRepo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ResourceRole findResourceRole(Long id) {
		return resourceRoleRepo.findById(id).orElse(null);
	}
	
	public List<ResourceRole> findByRoleId(Long roleId){
		return resourceRoleRepo.findByRoleId(roleId);
	}
	
	public List<ResourceRole> findByResourceId(Long resourceId){
		return resourceRoleRepo.findByResourceId(resourceId);
	}
	
	public List<ResourceRole> getResourceRoleList(){
		return resourceRoleRepo.findAll();
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ResourceRoleDetails> getResourceRoleDetailsListByRoleId(Long roleId){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<ResourceRoleDetails> resourceList = new ArrayList<>();
		List<Object[]> results = em.createQuery("SELECT rr.id,res.id,res.resourceName,r.id,r.roleName,rr.canAdd,rr.canEdit,rr.canView,rr.canDelete,rr.entryTime,rr.entryBy,u.username FROM ResourceRole rr\r\n" + 
				"LEFT JOIN Resource res\r\n" + 
				"ON rr.resourceId = res.id\r\n" + 
				"LEFT JOIN Role r \r\n" + 
				"ON rr.roleId = r.id\r\n" + 
				"LEFT JOIN User u\r\n" + 
				"ON rr.entryBy = u.id \r\n"+
				"WHERE rr.roleId = '"+roleId+"'").getResultList();
		
		for(Object[] obj:results) {
			
			resourceList.add(new ResourceRoleDetails((Long)obj[0], (Long)obj[1], obj[2].toString(), (Long)obj[3], obj[4].toString(), (int)obj[5], (int)obj[6], (int)obj[7], (int)obj[8], (Timestamp)obj[9], (Long)obj[10],obj[11].toString()));
		}
		em.getTransaction().commit();
		em.close();
		return resourceList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getRoleNameListByUserId(Long userId){
		System.out.println("TEST"+emf);
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<String> roleList = new ArrayList<>();
		List<Object[]> results = em.createQuery("SELECT r.roleName FROM UsersRoles ur\r\n" + 
				"JOIN Role r\r\n" + 
				"ON ur.roleId = r.id\r\n" + 
				"WHERE ur.userId = '"+userId+"'").getResultList();
		
		for(Object[] obj:results) {
			
			roleList.add(obj.toString());
		}
		em.getTransaction().commit();
		em.close();
		return roleList;
	}
}
