package com.manager.example.shareModel;

public enum CustomerType {

	General_Customer(1),
	Corporate_Customer(2),
	Reseller_Customer(3);
	private int type;
	private CustomerType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
