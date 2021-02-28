package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complain_tms")
public class ComplainTMS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerId;
	private String problemType;
	private String customerName;
	private String area;
	private String complainDetails;
	private int priority;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getComplainDetails() {
		return complainDetails;
	}
	public void setComplainDetails(String complainDetails) {
		this.complainDetails = complainDetails;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
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
	
	
}
