package com.swapstech.boss.payment.model;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;

import com.swapstech.boss.common.model.Document;

public class Payment implements Serializable{
	private static final long serialVersionUID = -379687940556643610L;
	@Id
	private String id;
	private String entityId;
	private String recurringScheduleId;
	private String paymentDate;
	private String fromAccountId;
	private String payeeAccountId;
	private String paymentAmount;
	private String paymentNotes;
	private String messageToPayee;
	private String deliveryChannel;
	private String feeAmount;
	private String feeCcy;
	private String feePaidBy;
	private String status;
	private Boolean isInternational;
	private Document documents;
	
	private String purposeOfPayment;
	private String phoneNumber;
	private String emailAddress;
	
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
	public String getRecurringScheduleId() {
		return recurringScheduleId;
	}
	public void setRecurringScheduleId(String recurringScheduleId) {
		this.recurringScheduleId = recurringScheduleId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getPayeeAccountId() {
		return payeeAccountId;
	}
	public void setPayeeAccountId(String payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentNotes() {
		return paymentNotes;
	}
	public void setPaymentNotes(String paymentNotes) {
		this.paymentNotes = paymentNotes;
	}
	public String getMessageToPayee() {
		return messageToPayee;
	}
	public void setMessageToPayee(String messageToPayee) {
		this.messageToPayee = messageToPayee;
	}
	public String getDeliveryChannel() {
		return deliveryChannel;
	}
	public void setDeliveryChannel(String deliveryChannel) {
		this.deliveryChannel = deliveryChannel;
	}
	public String getFeeAmount() {
		return feeAmount;
	}
	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}
	public String getFeeCcy() {
		return feeCcy;
	}
	public void setFeeCcy(String feeCcy) {
		this.feeCcy = feeCcy;
	}
	public String getFeePaidBy() {
		return feePaidBy;
	}
	public void setFeePaidBy(String feePaidBy) {
		this.feePaidBy = feePaidBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Document getDocuments() {
		return documents;
	}
	public void setDocuments(Document documents) {
		this.documents = documents;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}
	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}
	public Boolean getIsInternational() {
		return isInternational;
	}
	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}
	
	
}
