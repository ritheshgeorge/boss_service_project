package com.swapstech.boss.payee.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;
import com.swapstech.boss.payee.model.Payee;

public class PayeeDAO extends MongoDAO<Payee>{

	public PayeeDAO() {
		super(Payee.class);
	}
	
	public List<Payee> findAllPayeeByLEID(String LeId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(LeId))
			query.addCriteria(Criteria.where("entityId").is( LeId));
		return getMongoTemplate().find( query, Payee.class);
	}
	
	public Payee findByPayeeIdAndLEID(String id, String LeId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(id))
			query.addCriteria(Criteria.where("id").is( id));
		if(StringUtils.isNotEmpty(LeId))
			query.addCriteria(Criteria.where("entityId").is( LeId));
		
		return (Payee) getMongoTemplate().findOne( query, Payee.class);
	}
	
	public void removeByPayeeId(String payeeId){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(payeeId));
		Payee payee = getMongoTemplate().findOne(query, Payee.class);
		getMongoTemplate().remove(payee);
	}
	
	public static PayeeDAO getInstance(){
		return (PayeeDAO)AppContext.getApplicationContext().getBean("PayeeDAO");
	}

}
