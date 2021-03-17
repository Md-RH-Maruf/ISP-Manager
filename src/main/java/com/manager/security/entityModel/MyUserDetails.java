package com.manager.security.entityModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.manager.security.entity.User;
import com.manager.security.services.ResourceRoleService;

public class MyUserDetails implements UserDetails {

	private User user;
	private List<String> userRoles ;
	@Autowired
	ResourceRoleService resourceRoleService;
	public MyUserDetails(User user) {
		super();
		this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		/*
		 * this.userRoles = resourceRoleService.getRoleNameListByUserId(user.getId());
		 * List<GrantedAuthority> list = new ArrayList<GrantedAuthority>(); for(String
		 * role: userRoles) { list.add(new SimpleGrantedAuthority(role)); }
		 * 
		 * return list;
		 */
		 
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	
	public long getId() {
		return user.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public int getUserType() {
		return user.getUserType();
	}
	
	public String getMemberId() {
		return user.getMemberId();
	}
}
