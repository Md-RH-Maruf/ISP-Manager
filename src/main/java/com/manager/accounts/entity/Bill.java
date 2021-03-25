package com.manager.accounts.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_bills")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String billNo;
	private int billType;
	private String ticketId;
	private String customerId;
	private Date billDate;
	private double totalAmount;
	private double approveAmount;
	private int status;
	private int approveBy;
	private Date approveDate;
	private int rejectedBy;
	private String rejectedCause;
	private String receiverTakenFrom;
	private Timestamp entryTime;
	private Long entryBy;
	
	public Bill() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public int getBillType() {
		return billType;
	}
	public void setBillType(int billType) {
		this.billType = billType;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getApproveAmount() {
		return approveAmount;
	}
	public void setApproveAmount(double approveAmount) {
		this.approveAmount = approveAmount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(int approveBy) {
		this.approveBy = approveBy;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
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
	public int getRejectedBy() {
		return rejectedBy;
	}
	public void setRejectedBy(int rejectedBy) {
		this.rejectedBy = rejectedBy;
	}
	public String getRejectedCause() {
		return rejectedCause;
	}
	public void setRejectedCause(String rejectedCause) {
		this.rejectedCause = rejectedCause;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getReceiverTakenFrom() {
		return receiverTakenFrom;
	}
	public void setReceiverTakenFrom(String receiverTakenFrom) {
		this.receiverTakenFrom = receiverTakenFrom;
	}
	
	
}
