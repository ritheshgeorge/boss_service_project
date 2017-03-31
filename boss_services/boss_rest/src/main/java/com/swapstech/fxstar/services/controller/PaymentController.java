package com.swapstech.fxstar.services.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.swapstech.boss.common.model.DeliveryMethod;
import com.swapstech.boss.common.model.Document;
import com.swapstech.boss.payee.dao.PayeeDAO;
import com.swapstech.boss.payee.model.Payee;
import com.swapstech.boss.payment.dao.PaymentDAO;
import com.swapstech.boss.payment.dao.RecurringPaymentDAO;
import com.swapstech.boss.payment.model.Payment;
import com.swapstech.boss.payment.model.RecurringPayment;
import com.swapstech.boss.util.PaymentUtil;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@RequestMapping("/savePayment")
	public Map<String,Object> savePayee(@RequestParam String paymentJSON, @RequestParam(required=false) String recurringPaymentJSON) {
		Map<String,Object> map = new HashMap<String,Object>();
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
				
				if(!StringUtils.isEmpty(recurringPaymentJSON)){
					RecurringPayment recurring = gson.fromJson(recurringPaymentJSON, RecurringPayment.class);
					if(recurring.getFrequency()!=null && !recurring.getFrequency().trim().isEmpty())
						{
						if(StringUtils.isEmpty(recurring.getPaymentId()))
							recurring.setPaymentId(payment.getId());
						RecurringPaymentDAO.getInstance().save(recurring);
						payment.setRecurringScheduleId(recurring.getId());
						PaymentDAO.getInstance().save(payment);
						}
				}
				
				map.put("paymentId", payment.getId());
				map.put("code", "success");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			//Change it to logger
			map.put("exception", ex);
			map.put("code", "error");
		}
		return map;
	}
	
	@RequestMapping("/getAllPayment")
	public List<Payment> getAllPayment(
			@RequestParam String leId
			){
		List<Payment> payeeList = new ArrayList<Payment>();
		 payeeList = PaymentDAO.getInstance().findAllPaymentByLEID(leId);
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
			map.put("exception", ex);
			map.put("code", "error");
		}
		return map;
	}
	
	@RequestMapping("/getRecurringPayment")
	public Map<String,Object> getRecurringPayment(
			@RequestParam String paymentId
			){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			RecurringPayment recurring = new RecurringPayment();
			if(StringUtils.isNotBlank(paymentId)){
				recurring = RecurringPaymentDAO.getInstance().findOneRecurringByPaymentId(paymentId);
				map.put("recurringPayment", recurring);
			}
			map.put("code", "success");
		}catch(Exception ex){
			//log exception
			map.put("exception", ex);
			map.put("code", "error");
		}
		return map;
	}
	
	@RequestMapping("/requestRate")
	public Map<String,Object> requestRate(
			@RequestParam String ccy1,
			@RequestParam String ccy2,
			@RequestParam String dealCcy,
			@RequestParam String dealAmount,
			@RequestParam String entityId,
			@RequestParam String paymentDate
			){
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		map.put("ccy1Amount", dealAmount);
		map.put("ccy2Amount", (Integer.parseInt(dealAmount) * 1.7 ));
		map.put("exchangeRate", 1.7);
		map.put("baseCcy", ccy1);
		map.put("QuoteCcy", ccy2);
		map.put("expiry", 20);
		
		return map;
	}
	@RequestMapping("/getPaymentDeliveryMethod")
	public Map<String,Object> getPaymentDeliveryMethod(
			@RequestParam String ccy
			){
		Map<String,Object> map = new HashMap<String,Object>();
		map = PaymentUtil.getPayemntDeliveryStaticMethodList(ccy);
		return map;
	}
	@RequestMapping("/getPaymentFees")
	public Map<String,Object> getPaymentFees(
			@RequestParam String ccy,
			@RequestParam String method
			){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("feeAmount", (method.equals("Wire"))?25:(method.equals("ACH"))?5:0);
		map.put("feeCcy", "USD");
		return map;
	}
	
	@RequestMapping("/uploadDocumets")
	public Map<String,Object> uploadDocuments(
			@RequestParam CommonsMultipartFile file,
			@RequestParam String paymentId,
			@RequestParam String leId
			){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
		Payment payment = PaymentDAO.getInstance().findOneByPaymentId(leId, paymentId);
		List<Document> docList = new ArrayList<Document>();
		//for(CommonsMultipartFile file:files){
			if(file!=null){
				String[] fileInfo = PaymentUtil.uploadDocument(file);
				Document document = new Document();
				document.setLegalEntityId(leId);
				LocalDate date = new LocalDate();
				document.setCreateTime(date.toString(fmt));
				document.setSourceObjectId(payment.getId());
				document.setFileName(fileInfo[1]);
				document.setDirectory(fileInfo[0]);
				docList.add(document);
			}
		//}
			payment.setDocuments(docList);
			PaymentDAO.getInstance().save(payment);
			map.put("result", "success");
		}catch(Exception ex){
			map.put("result", "error");
			map.put("exception", ex);
		}
		
		
		
		
		
		
		return map;
	}
	
}
