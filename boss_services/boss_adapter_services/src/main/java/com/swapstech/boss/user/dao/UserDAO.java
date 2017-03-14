package com.swapstech.boss.user.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.swapstech.boss.common.dao.MongoDAO;
import com.swapstech.boss.common.util.AppContext;
import com.swapstech.boss.user.model.User;

public class UserDAO extends MongoDAO<User>{
	public UserDAO(){
		super(User.class);
	}
	
	public List<User> findAllUserByLEID(String leId){
		Query query = new Query();
		if(StringUtils.isNotEmpty(leId))
			query.addCriteria(Criteria.where("entityId").is( leId));
		return getMongoTemplate().find( query, User.class);
	}
	
	public User findUserbyIdAndleId(String id, String leId){
		Query query = new Query();
		User user = new User();
		if(StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(leId)){
		query.addCriteria(Criteria.where("id").is( id));
		query.addCriteria(Criteria.where("entityId").is( leId));
		user = getMongoTemplate().findOne( query, User.class);
		}
		return user;
	}
	
	public User findUserbyUserName(String userName){
		Query query = new Query();
		User user = new User();
		if(StringUtils.isNotEmpty(userName)){
		query.addCriteria(Criteria.where("userName").is( userName));
		user = getMongoTemplate().findOne( query, User.class);
		}
		return user;
	}
	
	public Boolean saveUniqueUser(User user) {
		Boolean result = false;
		if (isUserUnique(user)) {
			getMongoTemplate().save(user);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	private Boolean isUserUnique(User user){
		User checkUser = findUserbyUserName(user.getUserName());
		Boolean result = (checkUser==null)?true:false;
		return result;
	}
	
	public static UserDAO getInstance(){
		return (UserDAO)AppContext.getApplicationContext().getBean("UserDAO");
	}
}
