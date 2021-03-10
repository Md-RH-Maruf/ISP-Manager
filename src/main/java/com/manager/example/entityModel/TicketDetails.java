package com.manager.example.entityModel;

public class TicketDetails {
	long id;
	String tmsNo;
	String customerId;
	String subject;
	String area;
	String status;
	String priority;
	String date;
	String followUpBy;
	String followUpTime;
	String owner;
	
	
	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TicketDetails(long id, String tmsNo, String customerId, String subject, String area, String status,
			String priority, String date, String followUpBy, String followUpTime, String owner) {
		super();
		this.id = id;
		this.tmsNo = tmsNo;
		this.customerId = customerId;
		this.subject = subject;
		this.area = area;
		this.status = status;
		this.priority = priority;
		this.date = date;
		this.followUpBy = followUpBy;
		this.followUpTime = followUpTime;
		this.owner = owner;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFollowUpBy() {
		return followUpBy;
	}

	public void setFollowUpBy(String followUpBy) {
		this.followUpBy = followUpBy;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTmsNo() {
		return tmsNo;
	}
	public void setTmsNo(String tmsNo) {
		this.tmsNo = tmsNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFollowUpTime() {
		return followUpTime;
	}
	public void setFollowUpTime(String followUpTime) {
		this.followUpTime = followUpTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
