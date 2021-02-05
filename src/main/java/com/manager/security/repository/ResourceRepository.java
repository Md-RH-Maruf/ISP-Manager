package com.manager.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.security.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{
	public Resource findByResourceName(String resourceName);
}
