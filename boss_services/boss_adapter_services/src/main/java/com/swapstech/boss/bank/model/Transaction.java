package com.swapstech.boss.bank.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Transaction implements Serializable{
	@Id
	private String id;
	
	private String accountId;
	private String transactionDate;
	private String postingDate;
	private String transactionType;
	private String crDrType;
	private String amount;
	private String description1;
	private String description2;
	private String remainingBalance;
	private String Status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getCrDrType() {
		return crDrType;
	}
	public void setCrDrType(String crDrType) {
		this.crDrType = crDrType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription1() {
		return description1;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public String getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(String remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
