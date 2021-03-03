package com.manager.example.shareModel;

public enum ConnectionType {

	Epon(1),
	P2P(2);
	private int type;
	private ConnectionType(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
