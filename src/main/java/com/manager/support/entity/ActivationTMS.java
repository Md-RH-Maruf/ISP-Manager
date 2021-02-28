package com.manager.support.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activation_tms")
public class ActivationTMS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private String area;
	private String contactPerson;
	private String contactNo;
	private String address;
	private int packageId;
	private String otc;
	private String mrc;
	private Date promissDate;
	private Timestamp entryTime;
	private long entryBy;
	
	
	public ActivationTMS() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getOtc() {
		return otc;
	}
	public void setOtc(String otc) {
		this.otc = otc;
	}
	public String getMrc() {
		return mrc;
	}
	public void setMrc(String mrc) {
		this.mrc = mrc;
	}
	public Date getPromissDate() {
		return promissDate;
	}
	public void setPromissDate(Date promissDate) {
		this.promissDate = promissDate;
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
