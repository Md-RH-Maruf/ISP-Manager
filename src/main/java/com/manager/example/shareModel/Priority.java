package com.manager.example.shareModel;

public enum Priority {

	LOW(1),
	MEDIUM(2),
	MODARATE(3),
	HIGH(3),
	EMARGENCY(3);
	private int type;
	private Priority(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
