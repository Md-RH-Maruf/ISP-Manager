package com.manager.example.shareModel;

public enum BillType {

	Create_Bill(1),
	Monthly_Invoice(2),
	Cash_Payment(3),
	Cash_Received(4),
	Issued_Bill(5);
	private int type;
	private BillType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
