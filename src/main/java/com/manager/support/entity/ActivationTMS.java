package com.manager.support.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_activation_tms")
public class ActivationTMS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tmsNo;
	private String customerId;
	private String subject;
	private String status;
	private String priority;
	private String owner="";
	private String activationStatus;
	private String note;
	private Date promissDate;
	private int lastFollowupBy;
	private Timestamp lastFollowupTime;
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

	
	public String getTmsNo() {
		return tmsNo;
	}
	public void setTmsNo(String tmsNo) {
		this.tmsNo = tmsNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	@Override
	public String toString() {
		return "ActivationTMS [id=" + id + ", tmsNo=" + tmsNo + ", customerId=" + customerId + ", subject=" + subject
				+ ", status=" + status + ", priority=" + priority + ", owner=" + owner + ", activationStatus="
				+ activationStatus + ", note=" + note + ", promissDate=" + promissDate + ", lastFollowupBy="
				+ lastFollowupBy + ", lastFollowupTime=" + lastFollowupTime + ", entryTime=" + entryTime + ", entryBy="
				+ entryBy + "]";
	}
	
	
	
}
