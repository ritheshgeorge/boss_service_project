package com.swapstech.fxstar.services.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.swapstech.boss.payee.dao.PayeeDAO;
import com.swapstech.boss.payee.model.Payee;

@RestController
@RequestMapping("/payee")
public class PayeeController {
	@RequestMapping("/savePayee")
	public void savePayee(@RequestParam String payee) {
		try {
			if (payee != null) {
				Gson gson = new Gson();
				Payee beneficiary = gson.fromJson(payee, Payee.class);
				beneficiary.setEntityId("abc123abc");
				PayeeDAO.getInstance().save(beneficiary);
			}
		} catch (Exception ex) {
			System.out.println(ex);
			//Change it to logger
		}
	}
	
	@RequestMapping("/getPayee")
	public Payee getPayee(
			@RequestParam String leId,
			@RequestParam String payeeId
			){
		Payee payee = PayeeDAO.getInstance().findByPayeeIdAndLEID(payeeId, leId);
		return payee;
	}
	@RequestMapping("/getAllPayee")
	public List<Payee> getAllPayee(
			@RequestParam String leId
			){
		List<Payee> payeeList = PayeeDAO.getInstance().findAllPayeeByLEID(leId);
		return payeeList;
	}
	
	@RequestMapping("/removePayee")
	public Map<String, String> removePayee(@RequestParam String payeeId) {
		Map<String, String> map = new HashMap();
		try {
			if(!StringUtils.isEmpty(payeeId)){
				PayeeDAO.getInstance().removeByPayeeId(payeeId);
				map.put("code", "success");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			map.put("code", "error");
		}
		return map;
	}
}
