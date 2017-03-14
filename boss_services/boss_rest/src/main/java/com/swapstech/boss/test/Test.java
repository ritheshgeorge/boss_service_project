package com.swapstech.boss.test;

import org.joda.time.LocalDate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swapstech.boss.bank.dao.TransactionDAO;
import com.swapstech.boss.bank.model.Transaction;
import com.swapstech.boss.payee.dao.PayeeDAO;
import com.swapstech.boss.payee.model.Payee;
import com.swapstech.boss.payment.dao.PaymentDAO;
import com.swapstech.boss.payment.model.Payment;

public class Test {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		new ClassPathXmlApplicationContext( "spring-server-beans.xml");
		LocalDate today = new LocalDate();
		int amt = 52000;
		int next = amt;
		for(int i=1;i<=15;i++){
			
			Transaction t = new Transaction();
			t.setAccountId("58c1ba19fdd2891de8599419"); //sACT 726
			LocalDate nextDate = today.plusDays(i);
			System.out.println(nextDate.toString());
			t.setTransactionDate(nextDate.toString());
			t.setTransactionType((i/2==0)?"Check Deposit":((i%4==0)?"ATM Withdrawel":"BillPay"));
			t.setCrDrType((i%2==0)?"Credit":"Debit");
			t.setAmount(String.valueOf((i*121)));
			t.setDescription1("Description for this transaction");
			t.setRemainingBalance(String.valueOf(next));
			t.setStatus("Pending");
			next = amt-(i*121);
			TransactionDAO.getInstance().save(t);
		}
		
		
	}
}
