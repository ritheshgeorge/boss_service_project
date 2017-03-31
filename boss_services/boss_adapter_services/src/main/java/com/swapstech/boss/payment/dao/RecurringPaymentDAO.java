package com.swapstech.boss.payment.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;
import com.swapstech.boss.payment.model.Payment;
import com.swapstech.boss.payment.model.RecurringPayment;

public class RecurringPaymentDAO extends MongoDAO<RecurringPayment>{
	public RecurringPaymentDAO(){
		super(RecurringPayment.class);
	}
	
	public RecurringPayment findOneRecurringByPaymentId(String paymentId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(paymentId))
			query.addCriteria(Criteria.where("paymentId").is(paymentId));
		return getMongoTemplate().findOne( query, RecurringPayment.class);
	}
	
	public static RecurringPaymentDAO getInstance(){
		return (RecurringPaymentDAO)AppContext.getApplicationContext().getBean("RecurringPaymentDAO");
	}
}
