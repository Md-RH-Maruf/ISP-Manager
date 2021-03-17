package com.manager.security.entity;

import java.sql.Timestamp;

public class ResourceRoleDetails {
	private Long id;
	private long resourceId;
	private String resourceName;
	private long roleId;
	private String roleName;
	private int canAdd;
	private int canEdit;
	private int canView;
	private int canDelete;
	private Timestamp entryTime;
	private Long entryBy;
	private String entryByName;
	
	
	
	
	public ResourceRoleDetails(Long id, long resourceId, String resourceName, long roleId, String roleName, int canAdd,
			int canEdit, int canView, int canDelete, Timestamp entryTime, Long entryBy, String entryByName) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.canAdd = canAdd;
		this.canEdit = canEdit;
		this.canView = canView;
		this.canDelete = canDelete;
		this.entryTime = entryTime;
		this.entryBy = entryBy;
		this.entryByName = entryByName;
	}
	public ResourceRoleDetails() {
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
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public long getCanAdd() {
		return canAdd;
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
	public void setCanAdd(int canAdd) {
		this.canAdd = canAdd;
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
	public String getEntryByName() {
		return entryByName;
	}
	public void setEntryByName(String entryByName) {
		this.entryByName = entryByName;
	}
	
	
	
}
