package com.manager.accounts.entity;

public class BillInfo {
	
	long id;
	String billNo;
	String billDate;
	String createdBy;
	String ticketId;
	String billHead;
	String description;
	double totalAmount;
	double approveAmount;
	String billStatus;
	String approvedBy;
	String approvedDate;
	String rejectedBy;
	String rejectedDate;
	String rejectedCause;
	
	
	public BillInfo() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getBillHead() {
		return billHead;
	}
	public void setBillHead(String billHead) {
		this.billHead = billHead;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getRejectedBy() {
		return rejectedBy;
	}
	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}
	public String getRejectedCause() {
		return rejectedCause;
	}
	public void setRejectedCause(String rejectedCause) {
		this.rejectedCause = rejectedCause;
	}
	
	
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getRejectedDate() {
		return rejectedDate;
	}
	public void setRejectedDate(String rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

}
