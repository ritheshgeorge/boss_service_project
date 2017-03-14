package com.swapstech.boss.bank.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.bank.model.BankAccount;
import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;

public class BankAccountDAO extends MongoDAO<BankAccount>{

	public BankAccountDAO() {
		super(BankAccount.class);
	}
	
	public List<BankAccount> findAllAccountByLeId(String leId){
		Query query = new Query();
		query.addCriteria(Criteria.where("EntityId").is( leId));
		return getMongoTemplate().find( query, BankAccount.class);
	}
	
	public BankAccount findOneByAccountId(String accountId){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(accountId));
		return getMongoTemplate().findOne(query, BankAccount.class);
	}
	
	public static BankAccountDAO getInstance(){
		return (BankAccountDAO)AppContext.getApplicationContext().getBean("BankAccountDAO");
	}	
}
