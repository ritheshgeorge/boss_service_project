package com.swapstech.boss.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.bank.model.Transaction;
import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;

public class TransactionDAO extends MongoDAO<Transaction>{
	public TransactionDAO(){
		super(Transaction.class);
	}
	
	public List<Transaction> getTransactionListByAccountId(String accountId){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		if(StringUtils.isNotEmpty(accountId)){
			Query query = new Query();
			query.addCriteria(Criteria.where("accountId").is( accountId));
			transactionList =  getMongoTemplate().find( query, Transaction.class);
		}
		return transactionList;
	}
	
	public static TransactionDAO getInstance(){
		return (TransactionDAO)AppContext.getApplicationContext().getBean("TransactionDAO");
	}	
}
