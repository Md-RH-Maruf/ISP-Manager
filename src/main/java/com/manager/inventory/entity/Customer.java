package com.manager.inventory.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerId;
	private String name;
	private String companyName;
	private String keyPerson;
	private String area;
	private String address;
	private String email;
	private String contactNo;
	private int packageId;
	private int customerType;
	private String otc;
	private String mrc;
	private String connectionType;
	private String onuMac;
	private String latLong;
	private String onuInterface;
	private String connectionPoint;
	private String ipAddress;
	private String clientMac;
	private Date serviceStartDate;
	private Date expireDate;
	private int activeStatus;
	private String reference;
	private Timestamp entryTime;
	private Long entryBy;
	
	public Customer() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getKeyPerson() {
		return keyPerson;
	}
	public void setKeyPerson(String keyPerson) {
		this.keyPerson = keyPerson;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOtc() {
		return otc;
	}

	public void setOtc(String otc) {
		this.otc = otc;
	}

	public String getMrc() {
		return mrc;
	}

	public void setMrc(String mrc) {
		this.mrc = mrc;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getOnuMac() {
		return onuMac;
	}

	public void setOnuMac(String onuMac) {
		this.onuMac = onuMac;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}

	public String getOnuInterface() {
		return onuInterface;
	}

	public void setOnuInterface(String onuInterface) {
		this.onuInterface = onuInterface;
	}

	public String getConnectionPoint() {
		return connectionPoint;
	}

	public void setConnectionPoint(String connectionPoint) {
		this.connectionPoint = connectionPoint;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getClientMac() {
		return clientMac;
	}

	public void setClientMac(String clientMac) {
		this.clientMac = clientMac;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerId=" + customerId + ", name=" + name + ", companyName=" + companyName
				+ ", keyPerson=" + keyPerson + ", area=" + area + ", address=" + address + ", email=" + email
				+ ", contactNo=" + contactNo + ", packageId=" + packageId + ", customerType=" + customerType + ", otc="
				+ otc + ", mrc=" + mrc + ", connectionType=" + connectionType + ", onuMac=" + onuMac + ", latLong="
				+ latLong + ", onuInterface=" + onuInterface + ", connectionPoint=" + connectionPoint + ", ipAddress="
				+ ipAddress + ", clientMac=" + clientMac + ", serviceStartDate=" + serviceStartDate + ", expireDate="
				+ expireDate + ", activeStatus=" + activeStatus + ", reference=" + reference + ", entryTime="
				+ entryTime + ", entryBy=" + entryBy + "]";
	}
	
	
	
}
