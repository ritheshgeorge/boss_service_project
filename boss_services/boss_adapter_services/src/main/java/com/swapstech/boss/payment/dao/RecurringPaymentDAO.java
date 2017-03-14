package com.swapstech.boss.payment.dao;

import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;
import com.swapstech.boss.payment.model.RecurringPayment;

public class RecurringPaymentDAO extends MongoDAO<RecurringPayment>{
	public RecurringPaymentDAO(){
		super(RecurringPayment.class);
	}
	
	public static RecurringPaymentDAO getInstance(){
		return (RecurringPaymentDAO)AppContext.getApplicationContext().getBean("PaymentDAO");
	}
}
