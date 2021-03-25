package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CommentDetails {

	private Long id;
	private String ticketId;
	private String comment;
	private String commentBy;
	private String entryTime;
	
	
	public CommentDetails() {
		super();
	}
	
	
	public CommentDetails(Long id, String ticketId, String comment, String commentBy, String entryTime) {
		super();
		this.id = id;
		this.ticketId = ticketId;
		this.comment = comment;
		this.commentBy = commentBy;
		this.entryTime = entryTime;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCommentBy() {
		return commentBy;
	}
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	
	
}
