package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_complain_tms")
public class ComplainTMS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tmsNo;
	private String customerId;
	private String subject;
	private String problemType;
	private String complainDetails;
	private String priority;
	private String status;
	private String owner;
	private int lastFollowupBy;
	private Timestamp lastFollowupTime;
	private Timestamp entryTime;
	private long entryBy;
	
	
	public ComplainTMS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	
	public String getTmsNo() {
		return tmsNo;
	}
	public void setTmsNo(String tmsNo) {
		this.tmsNo = tmsNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getComplainDetails() {
		return complainDetails;
	}
	public void setComplainDetails(String complainDetails) {
		this.complainDetails = complainDetails;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
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
	public int getLastFollowupBy() {
		return lastFollowupBy;
	}
	public void setLastFollowupBy(int lastFollowupBy) {
		this.lastFollowupBy = lastFollowupBy;
	}
	public Timestamp getLastFollowupTime() {
		return lastFollowupTime;
	}
	public void setLastFollowupTime(Timestamp lastFollowupTime) {
		this.lastFollowupTime = lastFollowupTime;
	}
	
	
}
