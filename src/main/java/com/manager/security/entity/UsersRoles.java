package com.manager.security.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UsersRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long userId;
	private long roleId;
	private Timestamp entryTime;
	private Long entryBy;
	
	
	public UsersRoles() {
		super();
	}
	
	
	public UsersRoles(long userId, long roleId, Timestamp entryTime, Long entryBy) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.entryTime = entryTime;
		this.entryBy = entryBy;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public Long getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(Long entryBy) {
		this.entryBy = entryBy;
	}
	
	
	
}
