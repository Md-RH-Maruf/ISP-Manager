package com.manager.example.shareModel;

public enum Designations {

	ADMIN(1),
	ACCOUNTS(2),
	STORE_MANAGER(3),
	SUPPORT_ENGINEER(4),
	MANAGER(5),
	FUSSION(6);
	private int type;
	private Designations(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
