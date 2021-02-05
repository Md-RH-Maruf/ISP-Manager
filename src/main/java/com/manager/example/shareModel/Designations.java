package com.manager.example.shareModel;

public enum Designations {

	Admin(1),
	Accounts(2),
	Store_Manager(3),
	Support_Engineer(4),
	Manager(5),
	Fussion(6);
	private int type;
	private Designations(int type) {
		this.type = type;
	}
	public int getType() {
		return this.type;
	}
}
