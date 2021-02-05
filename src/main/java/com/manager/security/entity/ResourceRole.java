package com.manager.security.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource_role")
public class ResourceRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long resourceId;
	private long roleId;
	private int canAdd = 1;
	private int canEdit = 1;
	private int canView = 1;
	private int canDelete = 1;
	private Timestamp entryTime;
	private Long entryBy;
	
	
	public ResourceRole() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getResourceId() {
		return resourceId;
	}
	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}
	public long getRoleId() {
		return roleId;
	}
	
	public int getCanAdd() {
		return canAdd;
	}
	public void setCanAdd(int canAdd) {
		this.canAdd = canAdd;
	}
	public int getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(int canEdit) {
		this.canEdit = canEdit;
	}
	public int getCanView() {
		return canView;
	}
	public void setCanView(int canView) {
		this.canView = canView;
	}
	public int getCanDelete() {
		return canDelete;
	}
	public void setCanDelete(int canDelete) {
		this.canDelete = canDelete;
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
