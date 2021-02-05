package com.manager.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.security.entity.UsersRoles;
import com.manager.security.repository.UsersRolesRepository;

@Service
public class UsersRolesService {

	@Autowired
	UsersRolesRepository usersRolesRepo;
	
	public UsersRoles saveUsersRoles(UsersRoles userRoles) {
		return usersRolesRepo.save(userRoles);
	}
	
	public void deleteUsersRoles(Long id) {
		usersRolesRepo.deleteById(id);
	}
	
	public UsersRoles findById(Long id) {
		return usersRolesRepo.findById(id).orElse(null);
	}
	
	public List<UsersRoles> findByUserId(Long userId){
		return usersRolesRepo.findByUserId(userId);
	}
	
	public List<UsersRoles> getAllUsersRolesList(){
		return usersRolesRepo.findAll();
	}
}
