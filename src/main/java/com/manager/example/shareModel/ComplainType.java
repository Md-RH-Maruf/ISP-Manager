package com.manager.example.shareModel;

public enum ComplainType {

	FIBER_CUT(1),
	INTERNET_BREAKDOWN(2),
	SLOW_INTERNET(3),
	OTHER(4);
	private int type;
	private ComplainType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
