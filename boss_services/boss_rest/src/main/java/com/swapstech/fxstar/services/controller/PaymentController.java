package com.swapstech.fxstar.services.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.swapstech.boss.payee.dao.PayeeDAO;
import com.swapstech.boss.payee.model.Payee;
import com.swapstech.boss.payment.dao.PaymentDAO;
import com.swapstech.boss.payment.model.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@RequestMapping("/savePayment")
	public Map<String,String> savePayee(@RequestParam String paymentJSON) {
		Map<String,String> map = new HashMap<String,String>();
		try {
			if (paymentJSON != null) {
				Gson gson = new Gson();
				Payment payment =  gson.fromJson(paymentJSON, Payment.class);
				payment.setEntityId("abc123abc");
				payment.setStatus("New");
				if(!StringUtils.isEmpty(payment.getPayeeAccountId())){
					Payee payee = PayeeDAO.getInstance().findById(payment.getPayeeAccountId()); 
					payment.setIsInternational(payee.getIsInternational());
				}
				
				PaymentDAO.getInstance().save(payment);
				map.put("code", "success");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			//Change it to logger
			map.put("code", "error");
		}
		return map;
	}
	
	@RequestMapping("/getAllPayment")
	public List<Payment> getAllPayment(
			@RequestParam String leId
			){
		List<Payment> payeeList = PaymentDAO.getInstance().findAllPaymentByLEID(leId);
		return payeeList;
	}
	
	@RequestMapping("/getPayment")
	public Map<String,Object> getPayment(
			@RequestParam String leId,
			@RequestParam String paymentId
			){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			Payment pay = PaymentDAO.getInstance().findOneByPaymentId(leId, paymentId);
			map.put("payment", pay);
			map.put("code", "success");
		}catch(Exception ex){
			//log exception
			System.out.println(ex);
			map.put("code", "error");
		}
		return map;
	}
	
}
