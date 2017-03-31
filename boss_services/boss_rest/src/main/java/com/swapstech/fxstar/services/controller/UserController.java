package com.swapstech.fxstar.services.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.swapstech.boss.payment.dao.PaymentDAO;
import com.swapstech.boss.payment.model.Payment;
import com.swapstech.boss.user.dao.UserDAO;
import com.swapstech.boss.user.model.User;

@RestController
@RequestMapping("/user") 
public class UserController {
	
	@RequestMapping("/getUserList")
	public List<User> getAllPayment(
			@RequestParam String leId
			){
		List<User> userList = UserDAO.getInstance().findAllUserByLEID(leId);
		
		return userList;
	}
	@RequestMapping("/getUser")
	public User getUser(
			@RequestParam String id,
			@RequestParam String leId
			){
		User user = new User();
		try{
			user = UserDAO.getInstance().findUserbyIdAndleId(id, leId);
		}catch(Exception ex){
			System.out.println(ex);
		}
		return user;
	}

		@RequestMapping("/saveUser")
		public Boolean saveUser(
				@RequestParam String userJSON
				){
			Gson gson = new Gson();
			User user = gson.fromJson(userJSON, User.class);
			user.setEntityId("abc123abc");
			Boolean result = true;
			if(StringUtils.isNotEmpty(user.getId())){
				UserDAO.getInstance().save(user);
			}else{
				result = UserDAO.getInstance().saveUniqueUser(user);
			}
			return result;
		}
	
}
