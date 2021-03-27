package com.manager.example.shareModel;

public enum BillStatus {

	PENDING(1),
	APPROVED(2),
	NOT_APPROVED(3),
	ISSUED(4),
	DELETED(5);
	private int type;
	private BillStatus(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
