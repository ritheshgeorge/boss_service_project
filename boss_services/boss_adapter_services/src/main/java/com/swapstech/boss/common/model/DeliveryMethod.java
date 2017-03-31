package com.swapstech.boss.common.model;

import org.joda.time.LocalDate;

public class DeliveryMethod {
	private String method;
	private LocalDate time;
	private String ccy;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	
}
