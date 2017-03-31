/*package com.swapstech.boss.dummy;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swapstech.boss.bank.model.BankAccount;
import com.swapstech.boss.bank.model.Transaction;
import com.swapstech.boss.bank.dao.BankAccountDAO;
import com.swapstech.boss.bank.dao.TransactionDAO;

public class GenerateAccountObject {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		new ClassPathXmlApplicationContext( "spring-server-beans.xml");
	
	 * Generate Dummy Data for Account
	 
	for(int i=1;i<=5;i++){
		BankAccount account = new BankAccount();
		account.setEntityId("abc183kdig");
		account.setNicName("Business Account Name");
		account.setAccountNumber(String.valueOf((i+4)*121));
		account.setName("Business Checking Account");
		account.setAccountType(((i%2)==0)?"Checking":"Savings");
		//account code removed
		account.setCurrency(((i%2)==0)?"EUR":"USD");
		account.setAvailableBalance("52155");
		BankAccountDAO.getInstance().save(account);
	}
		
		
		 * 
		 * Generate Dummy data for Transaction i.e. Account Activity
		 
		int balance = 40000;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		for(int i=1;i<=5;i++){
			long random = ThreadLocalRandom.current().nextLong();
		    Date date = new Date(random);
			Transaction activity = new Transaction();
			activity.setAccountId("58c9af6662c32b7a34479cc6");
			activity.setTransactionType("ATM Withdrawl");
			//activity.setTransactionDate(date.get);
			activity.setDescription1("Description for this transaction");
			activity.setAmount("120"+i);
			activity.setRemainingBalance(String.valueOf(balance -i));
			activity.setStatus("Pending");
			TransactionDAO.getInstance().save(activity);
		}
		
		
	
	
	}
}
*/