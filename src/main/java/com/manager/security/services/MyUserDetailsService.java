package com.manager.security.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manager.security.entity.User;
import com.manager.security.entity.UsersRoles;
import com.manager.security.entityModel.MyUserDetails;
import com.manager.security.repository.UserRepository;
import com.manager.security.repository.UsersRolesRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UsersRolesRepository usersRolesRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User 404");
		}
		
		return new MyUserDetails(user);
	}

	@Transactional
	public String saveUser(User user) {
		try {
			user = userRepo.save(user);
			if(user.getUserType() == 1) {
				usersRolesRepo.save(new UsersRoles(user.getId(), 8, user.getEntryTime(), user.getEntryBy()));
			}else {
				usersRolesRepo.save(new UsersRoles(user.getId(), 7, user.getEntryTime(), user.getEntryBy()));
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "something wrong";
		}
		
		return "success";
	}
	
	public List<User> getUserList(){
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
}
