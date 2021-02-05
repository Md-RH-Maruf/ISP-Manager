package com.manager.example.shareModel;

public enum Nationalities {

	Bangladesh(1),
	India(2),
	China(3),
	Japan(4),
	England(5),
	Korea(6),
	America(7),
	Pakistan(8),
	Other(9);
	private int type;
	private Nationalities(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
