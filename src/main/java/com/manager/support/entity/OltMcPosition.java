package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "olt_mc_position")
public class OltMcPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String oltMcName;
	private String area;
	private String address;
	private Timestamp entryTime;
	private long entryBy;
	
	
	
	public OltMcPosition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOltMcName() {
		return oltMcName;
	}
	public void setOltMcName(String oltMcName) {
		this.oltMcName = oltMcName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	

}
