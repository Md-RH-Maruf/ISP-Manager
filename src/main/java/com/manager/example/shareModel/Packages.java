package com.manager.example.shareModel;

public enum Packages {

	Bandwidth_10Mbps(1),
	Bandwidth_15Mbps(2),
	Bandwidth_20Mbps(3),
	Bandwidth_30Mbps(4);
	private int type;
	private Packages(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
