package com.manager.security.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberId;
	private String username;
	private String password;
	private boolean enabled = true;
	private Integer userType;
	private String userRole;
	private Timestamp entryTime;
	private Long entryBy;
	

	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public long getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(long entryBy) {
		this.entryBy = entryBy;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public void setEntryBy(Long entryBy) {
		this.entryBy = entryBy;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", memberId=" + memberId + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", userType=" + userType + ", entryTime=" + entryTime + ", entryBy="
				+ entryBy + "]";
	}
	
	
}
