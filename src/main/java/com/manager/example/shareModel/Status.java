package com.manager.example.shareModel;

public enum Status {

	OPEN(1),
	PROCESSING(2),
	CLOSED(3),
	DELETED(4);
	private int type;
	private Status(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
