package com.manager.inventory.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reseller_info")
public class Reseller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String resellerId;
	private String name;
	private String address;
	private String publicIp;
	private String scrNo;
	private String email;
	private String contactNo;
	private String mikrotikUserName;
	private String mikrotikPassword;
	private String internetBandwidth;
	private String facebookBandwidth;
	private String youtubeBandwidth;
	private String bdixBandwidth;
	private double monthlyPayment;
	private Date serviceStartDate;
	private int status;
	private Timestamp entryTime;
	private Long entryBy;
	
	public Reseller() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResellerId() {
		return resellerId;
	}
	public void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getScrNo() {
		return scrNo;
	}

	public void setScrNo(String scrNo) {
		this.scrNo = scrNo;
	}

	public String getMikrotikUserName() {
		return mikrotikUserName;
	}

	public void setMikrotikUserName(String mikrotikUserName) {
		this.mikrotikUserName = mikrotikUserName;
	}

	public String getMikrotikPassword() {
		return mikrotikPassword;
	}

	public void setMikrotikPassword(String mikrotikPassword) {
		this.mikrotikPassword = mikrotikPassword;
	}

	public String getInternetBandwidth() {
		return internetBandwidth;
	}

	public void setInternetBandwidth(String internetBandwidth) {
		this.internetBandwidth = internetBandwidth;
	}

	public String getFacebookBandwidth() {
		return facebookBandwidth;
	}

	public void setFacebookBandwidth(String facebookBandwidth) {
		this.facebookBandwidth = facebookBandwidth;
	}

	public String getBdixBandwidth() {
		return bdixBandwidth;
	}

	public void setBdixBandwidth(String bdixBandwidth) {
		this.bdixBandwidth = bdixBandwidth;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
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

	public String getYoutubeBandwidth() {
		return youtubeBandwidth;
	}

	public void setYoutubeBandwidth(String youtubeBandwidth) {
		this.youtubeBandwidth = youtubeBandwidth;
	}
	
}
