package com.manager.support.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_mc_info")
public class McInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String popName;
	private String rackNo;
	private String chassiNo;
	private String clientName;
	private String switchPortNo;
	private String switchNo;
	private Timestamp entryTime;
	private long entryBy;
	
	public McInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPopName() {
		return popName;
	}
	public void setPopName(String popName) {
		this.popName = popName;
	}
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
	public String getChassiNo() {
		return chassiNo;
	}
	public void setChassiNo(String chassiNo) {
		this.chassiNo = chassiNo;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getSwitchPortNo() {
		return switchPortNo;
	}
	public void setSwitchPortNo(String switchPortNo) {
		this.switchPortNo = switchPortNo;
	}
	public String getSwitchNo() {
		return switchNo;
	}
	public void setSwitchNo(String switchNo) {
		this.switchNo = switchNo;
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
