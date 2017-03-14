package com.swapstech.boss.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.swapstech.boss.common.model.Entitlement;

public class User implements Serializable{
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String corporateId;
	private String phoneNumber;
	private String status;
	private String entityId;
	private BigDecimal failedLogins;
	private Map<String,Boolean> entitlements;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCorporateId() {
		return corporateId;
	}
	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getFailedLogins() {
		return failedLogins;
	}
	public void setFailedLogins(BigDecimal failedLogins) {
		this.failedLogins = failedLogins;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public Map<String,Boolean> getEntitlements() {
		return entitlements;
	}
	public void setEntitlements( Map<String,Boolean>  entitlements) {
		this.entitlements = entitlements;
	}
	
	
}
