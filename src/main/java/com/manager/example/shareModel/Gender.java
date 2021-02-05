package com.manager.example.shareModel;

public enum Gender {

	Male(1),
	Female(2),
	Other(3);
	private int type;
	private Gender(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
