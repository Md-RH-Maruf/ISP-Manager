package com.manager.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);
}
