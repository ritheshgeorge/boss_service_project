package com.swapstech.boss.dummy;

import java.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swapstech.boss.bank.model.BankAccount;
import com.swapstech.boss.bank.dao.BankAccountDAO;

public class GenerateAccountObject {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		new ClassPathXmlApplicationContext( "spring-server-beans.xml");
	/*
	 * Generate Dummy Data for Account
	 */
	for(int i=1;i<=5;i++){
		BankAccount account = new BankAccount();
		account.setEntityId("abc183kdig");
		account.setNicName("Business Account Name");
		account.setAccountNumber(String.valueOf((i+5)*121));
		account.setName("Business Checking Account");
		account.setAccountType(((i%2)==0)?"Checking":"Savings");
		//account code removed
		account.setCurrency(((i%2)==0)?"EUR":"USD");
		account.setAvailableBalance("52155");
		BankAccountDAO.getInstance().save(account);
	}
		
		
		
		
	
	
	}
}
