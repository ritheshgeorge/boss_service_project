package com.swapstech.boss.bank.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class BankAccount implements Serializable{
	private static final long serialVersionUID = -379687940556643610L;
	
	@Id
	private String id;
	
	private String entityId;
	private String name;
	private String nicName;
	private String accountNumber;
	private String currency;
	private String accountType;
	private String accountFamily;
	private String bankNationalCode;
	private String ledgerBalance;
	private String availableBalance;
	private String unpostedBalance;
	
	public BankAccount(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountFamily() {
		return accountFamily;
	}
	public void setAccountFamily(String accountFamily) {
		this.accountFamily = accountFamily;
	}
	public String getBankNationalCode() {
		return bankNationalCode;
	}
	public void setBankNationalCode(String bankNationalCode) {
		this.bankNationalCode = bankNationalCode;
	}
	public String getLedgerBalance() {
		return ledgerBalance;
	}
	public void setLedgerBalance(String ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}
	public String getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getUnpostedBalance() {
		return unpostedBalance;
	}
	public void setUnpostedBalance(String unpostedBalance) {
		this.unpostedBalance = unpostedBalance;
	}

	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	
}
