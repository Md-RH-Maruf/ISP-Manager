package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int sourceId;
	private int tms_type;
	private String tms_no;
	private String subject;
	private Timestamp time;
	private String followupTime;
	private int status;
	private int priority;
	private int owner;
	private String workTeam;
	private int lastEditBy;
	private Timestamp entryTime;
	private Long entryBy;
	
	public Ticket() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getTms_type() {
		return tms_type;
	}
	public void setTms_type(int tms_type) {
		this.tms_type = tms_type;
	}
	public String getTms_no() {
		return tms_no;
	}
	public void setTms_no(String tms_no) {
		this.tms_no = tms_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getFollowupTime() {
		return followupTime;
	}
	public void setFollowupTime(String followupTime) {
		this.followupTime = followupTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public String getWorkTeam() {
		return workTeam;
	}
	public void setWorkTeam(String workTeam) {
		this.workTeam = workTeam;
	}
	public int getLastEditBy() {
		return lastEditBy;
	}
	public void setLastEditBy(int lastEditBy) {
		this.lastEditBy = lastEditBy;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public Long getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(Long entryBy) {
		this.entryBy = entryBy;
	}
	
	
}
