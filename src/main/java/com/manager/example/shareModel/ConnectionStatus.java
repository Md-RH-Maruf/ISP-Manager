package com.manager.example.shareModel;

public enum ConnectionStatus {

	Active(1),
	Disconnected(2),
	Stable(2),;
	private int type;
	private ConnectionStatus(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
