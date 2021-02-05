package com.manager.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.security.entity.ResourceRole;

@Repository
public interface ResourceRoleRepository extends JpaRepository<ResourceRole, Long>{
	public List<ResourceRole> findByResourceId(Long resourceId);
	public List<ResourceRole> findByRoleId(Long roleId);
}
