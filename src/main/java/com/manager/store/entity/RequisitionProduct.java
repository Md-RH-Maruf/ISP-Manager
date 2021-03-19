package com.manager.store.entity;

public class RequisitionProduct {
	long id;
	String requisitionNo;
	String productId;
	String productName;
	long quantity;
	String description;
	
	
	
	public RequisitionProduct(long id, String requisitionNo, String productId, String productName, long quantity,
			String description) {
		super();
		this.id = id;
		this.requisitionNo = requisitionNo;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.description = description;
	}
	public String getRequisitionNo() {
		return requisitionNo;
	}
	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}
	public RequisitionProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
