package com.manager.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.security.entity.Role;
import com.manager.security.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	public RoleRepository roleRepo;
	
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}
	
	public Role findRole(long id) {
		return roleRepo.findById(id).orElse(null);
	}
	
	public Role findRoleByRoleName(String roleName) {
		return roleRepo.findByRoleName(roleName);
	}
	
	public List<Role> getRoleList(){
		return roleRepo.findAll();
	}
}
