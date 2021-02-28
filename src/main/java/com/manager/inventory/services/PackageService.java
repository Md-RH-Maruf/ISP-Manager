package com.manager.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.inventory.repository.ServiceRepository;

@Service
public class PackageService {
	
	@Autowired
	ServiceRepository serviceRepo;
	
	public com.manager.inventory.entity.Service saveService(com.manager.inventory.entity.Service service){
		return serviceRepo.save(service);
	}
	
	public com.manager.inventory.entity.Service findById(Long id){
		return serviceRepo.findById(id).orElse(null);
	}
	
	public com.manager.inventory.entity.Service findByServiceName(String serviceName){
		return serviceRepo.findByServiceName(serviceName);
	}
	
	public List<com.manager.inventory.entity.Service> getServiceList(){
		return serviceRepo.findAll();
	}
	
	public boolean isServiceExist(String serviceName,long id) {
		if(serviceRepo.findByServiceNameAndIdNot(serviceName, id) == null) {
			return false;
		}else {
			return true;
		}
	}
}
