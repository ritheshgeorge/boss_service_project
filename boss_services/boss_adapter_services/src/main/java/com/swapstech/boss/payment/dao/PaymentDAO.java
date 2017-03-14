package com.swapstech.boss.payment.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;
import com.swapstech.boss.payment.model.Payment;

public class PaymentDAO extends MongoDAO<Payment>{
	public PaymentDAO(){
		super(Payment.class);
	}
	
	public List<Payment> findAllPaymentByLEID(String LeId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(LeId))
			query.addCriteria(Criteria.where("entityId").is( LeId));
		return getMongoTemplate().find( query, Payment.class);
	}
	
	public Payment findOneByPaymentId(String leId,String paymentId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(leId))
			query.addCriteria(Criteria.where("entityId").is( leId));
		if(StringUtils.isNotEmpty(paymentId))
			query.addCriteria(Criteria.where("id").is(paymentId));
		return getMongoTemplate().findOne( query, Payment.class);
	}
	
	public static PaymentDAO getInstance(){
		return (PaymentDAO)AppContext.getApplicationContext().getBean("PaymentDAO");
	}
}
