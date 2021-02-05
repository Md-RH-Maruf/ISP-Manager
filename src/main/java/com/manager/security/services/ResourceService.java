package com.manager.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.security.entity.Resource;
import com.manager.security.repository.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	ResourceRepository resourceRepo;
	
	public Resource saveResource(Resource resource) {
		return resourceRepo.save(resource);
	}
	
	public Resource findResource(long id) {
		return resourceRepo.findById(id).orElse(null);
	}
	
	public Resource findResourceByResourceName(String resourceName) {
		return resourceRepo.findByResourceName(resourceName);
	}
	
	public List<Resource> getResourceList(){
		return resourceRepo.findAll();
	}
}
