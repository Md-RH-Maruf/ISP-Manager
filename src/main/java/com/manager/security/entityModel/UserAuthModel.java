package com.manager.security.entityModel;

import java.util.List;

import com.manager.security.entity.UsersRoles;

public class UserAuthModel {
	
	private Long id;
	private String memberId;
	private String username;
	private Integer userType;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String designation;
	private boolean enabled;
	private List<UsersRoles> userRoles;
	
	
	public UserAuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAuthModel(Long id, String memberId, String username, Integer userType, String firstName, String lastName,
			String email, String contactNo, String designation, boolean enabled, List<UsersRoles> userRoles) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.username = username;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.designation = designation;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<UsersRoles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UsersRoles> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	

}
