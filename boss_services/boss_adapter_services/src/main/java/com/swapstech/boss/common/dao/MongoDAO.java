package com.swapstech.boss.common.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.bank.model.BankAccount;

public abstract class MongoDAO<E> {
	private static Logger logger = LoggerFactory.getLogger(MongoDAO.class);
	private MongoTemplate mongoTemplate;

	Class<E> type = null;

	public MongoDAO(Class<E> type) {
		this.type = type;
	}

	public List<E> findAllbyFieldName(String fname) {
		Query q = new Query();
		q.fields().include(fname);
		return mongoTemplate.find(q, type);		
	}

	public List<E> findAll() {
		return mongoTemplate.findAll( type);
	}

	public E findById( String id) {
		return mongoTemplate.findById( id, type);
	}

	public List<E> findByQuery( Query query) {
		return mongoTemplate.find( query, type);
	}

	public void save( E obj) {
			mongoTemplate.save( obj);
			}
	public void deleteById( String id) {
		mongoTemplate.remove( findById( id));
	}

	public void delete( E obj) {
		mongoTemplate.remove( obj);
	}

	public void deleteAll() {
		mongoTemplate.remove( new Query(), type);
	}
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
