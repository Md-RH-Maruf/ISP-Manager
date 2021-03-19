package com.manager.accounts.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String billNo;
	private int transactionType;
	private String debitLedger;
	private String creditLedger;
	private double amount;
	private String description;
	private int status;
	private Timestamp entryTime;
	private Long entryBy;
	
	public Transaction() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public String getDebitLedger() {
		return debitLedger;
	}
	public void setDebitLedger(String debitLedger) {
		this.debitLedger = debitLedger;
	}
	public String getCreditLedger() {
		return creditLedger;
	}
	public void setCreditLedger(String creditLedger) {
		this.creditLedger = creditLedger;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
