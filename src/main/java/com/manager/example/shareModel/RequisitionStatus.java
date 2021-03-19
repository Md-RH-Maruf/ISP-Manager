package com.manager.example.shareModel;

public enum RequisitionStatus {

	PENDING(1),
	APPROVED(2),
	NOT_APPROVED(3),
	ISSUED(4);
	private int type;
	private RequisitionStatus(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
