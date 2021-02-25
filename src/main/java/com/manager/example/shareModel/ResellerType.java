package com.manager.example.shareModel;

public enum ResellerType {

	General_Reseller(1),
	Corporate_Reseller(2),
	Paid_Reseller(3);
	private int type;
	private ResellerType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
