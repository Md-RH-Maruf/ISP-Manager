package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "connection_point")
public class ConnectionPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String connectionPointName;
	private int connectionType;
	private int activeStatus;
	private String clientName;
	private String server;
	private String ipAddress;
	private String eponInterface;
	private String onuMac;
	private String clientMac;
	private String graphId;
	private Timestamp entryTime;
	private long entryBy;
	
	
	
	public ConnectionPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConnectionPointName() {
		return connectionPointName;
	}
	public void setConnectionPointName(String connectionPointName) {
		this.connectionPointName = connectionPointName;
	}
	
	public int getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(int connectionType) {
		this.connectionType = connectionType;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getEponInterface() {
		return eponInterface;
	}
	public void setEponInterface(String eponInterface) {
		this.eponInterface = eponInterface;
	}
	public String getOnuMac() {
		return onuMac;
	}
	public void setOnuMac(String onuMac) {
		this.onuMac = onuMac;
	}
	public String getClientMac() {
		return clientMac;
	}
	public void setClientMac(String clientMac) {
		this.clientMac = clientMac;
	}
	public String getGraphId() {
		return graphId;
	}
	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public long getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(long entryBy) {
		this.entryBy = entryBy;
	}
	
	
}
