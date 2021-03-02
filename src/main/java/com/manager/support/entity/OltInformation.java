package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "olt_info")
public class OltInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String oltName;
	private String oltPortNo;
	private String connectionPointName;
	private String spliterOdfNo;
	private String spliterOdfPortNo;
	private String fiberOdfNo;
	private String fiberOdfPortNo;
	private Timestamp entryTime;
	private long entryBy;
	
	
	
	public OltInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getOltName() {
		return oltName;
	}
	public void setOltName(String oltName) {
		this.oltName = oltName;
	}
	public String getOltPortNo() {
		return oltPortNo;
	}
	public void setOltPortNo(String oltPortNo) {
		this.oltPortNo = oltPortNo;
	}
	public String getConnectionPointName() {
		return connectionPointName;
	}
	public void setConnectionPointName(String connectionPointName) {
		this.connectionPointName = connectionPointName;
	}
	public String getSpliterOdfNo() {
		return spliterOdfNo;
	}
	public void setSpliterOdfNo(String spliterOdfNo) {
		this.spliterOdfNo = spliterOdfNo;
	}
	public String getSpliterOdfPortNo() {
		return spliterOdfPortNo;
	}
	public void setSpliterOdfPortNo(String spliterOdfPortNo) {
		this.spliterOdfPortNo = spliterOdfPortNo;
	}
	public String getFiberOdfNo() {
		return fiberOdfNo;
	}
	public void setFiberOdfNo(String fiberOdfNo) {
		this.fiberOdfNo = fiberOdfNo;
	}
	public String getFiberOdfPortNo() {
		return fiberOdfPortNo;
	}
	public void setFiberOdfPortNo(String fiberOdfPortNo) {
		this.fiberOdfPortNo = fiberOdfPortNo;
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
