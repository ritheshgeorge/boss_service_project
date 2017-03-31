package com.swapstech.fxstar.services.controller;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapstech.boss.bank.dao.BankAccountDAO;
import com.swapstech.boss.bank.dao.TransactionDAO;
import com.swapstech.boss.bank.model.BankAccount;
import com.swapstech.boss.bank.model.Transaction;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
	@RequestMapping("/getAccount_list/{leId}")
	public List<BankAccount> getBankAccountList(
			@PathVariable("leId") String entityId
			){
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		accountList = BankAccountDAO.getInstance().findAllAccountByLeId(entityId);
		return accountList;
	}
	
	@RequestMapping("/getAccountActivity")
	public Map<String,Object> getAccountActivity(
			@RequestParam String accountId
			){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			BankAccount account = BankAccountDAO.getInstance().findOneByAccountId(accountId);
			map.put("account",account);
			List<Transaction> activityList = TransactionDAO.getInstance().getTransactionListByAccountId(accountId);
			map.put("activityList", activityList);
			map.put("code", "success");
		}catch(Exception ex){
			//User logger 
			System.out.println(ex);
			map.put("code", "error");
		}
	
		return map;
	}
	
}
