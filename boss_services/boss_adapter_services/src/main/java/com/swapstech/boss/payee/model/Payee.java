package com.swapstech.boss.payee.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import org.springframework.data.annotation.Id;

import com.swapstech.boss.common.model.Address;
import com.swapstech.boss.common.model.Bank;

public class Payee implements Serializable{
	private static final long serialVersionUID = -379687940556643610L;
	
	@Id
	private String id;
	private String entityId;
	private String recipientType; //Not in DataModel
	private String aliasName;
	private String legalName;
	private Address legalAddress;
	private Bank accountWithBank;
	private String accountNumber;
	private String accountCcy;
	private String phoneNumber;
	private String emailAddress;
	private Boolean isInternational;
	private Bank intermediaryBank;
	private LinkedHashMap<String,String> countrySpecificFields;
	private String status;
	private String effectiveDate;
	private String defaultPaymentNotes;
	private Address address; // why legal Address and address
	
	
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
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public Address getLegalAddress() {
		return legalAddress;
	}
	public void setLegalAddress(Address legalAddress) {
		this.legalAddress = legalAddress;
	}
	public Bank getAccountWithBank() {
		return accountWithBank;
	}
	public void setAccountWithBank(Bank accountWithBank) {
		this.accountWithBank = accountWithBank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountCcy() {
		return accountCcy;
	}
	public void setAccountCcy(String accountCcy) {
		this.accountCcy = accountCcy;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getIsInternational() {
		return isInternational;
	}
	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}
	public Bank getIntermediaryBank() {
		return intermediaryBank;
	}
	public void setIntermediaryBank(Bank intermediaryBank) {
		this.intermediaryBank = intermediaryBank;
	}
	public LinkedHashMap<String, String> getCountrySpecificFields() {
		return countrySpecificFields;
	}
	public void setCountrySpecificFields(LinkedHashMap<String, String> countrySpecificFields) {
		this.countrySpecificFields = countrySpecificFields;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getDefaultPaymentNotes() {
		return defaultPaymentNotes;
	}
	public void setDefaultPaymentNotes(String defaultPaymentNotes) {
		this.defaultPaymentNotes = defaultPaymentNotes;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	
	
}
