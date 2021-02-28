package com.manager.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.inventory.entity.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
	public Service findByServiceName(String serviceName);
	public Service findByServiceNameAndIdNot(String serviceName,long id);
}
