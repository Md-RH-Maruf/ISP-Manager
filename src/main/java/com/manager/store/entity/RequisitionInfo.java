package com.manager.store.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class RequisitionInfo {
	long id;
	String requisitionNo;
	String requisitionDate;
	String ticketId;
	long productQuantity;
	String createdBy;
	String issuedBy;
	Date issuedDate;
	String approvedBy;
	Date approvedDate;
	
	
	public RequisitionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequisitionInfo(long id, String requisitionNo, String requisitionDate, String ticketId,
			long productQuantity, String createdBy) {
		super();
		this.id = id;
		this.requisitionNo = requisitionNo;
		this.requisitionDate = requisitionDate;
		this.ticketId = ticketId;
		this.productQuantity = productQuantity;
		this.createdBy = createdBy;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRequisitionNo() {
		return requisitionNo;
	}
	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}
	public String getRequisitionDate() {
		return requisitionDate;
	}
	public void setRequisitionDate(String requisitionDate) {
		this.requisitionDate = requisitionDate;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	
	
	
	
}
