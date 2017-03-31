package com.swapstech.boss.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.swapstech.boss.common.model.DeliveryMethod;

public class PaymentUtil {
	public static Map<String,Object> getPayemntDeliveryStaticMethodList(String ccy){
		Map<String,Object> map = new HashMap<String,Object>();
		List<DeliveryMethod> deliveryMethodList = new ArrayList<DeliveryMethod>();
		for(int i =0;i<=2;i++){
			DeliveryMethod method = new DeliveryMethod();
			method.setMethod((i==0)?"Wire":(i==1)?"ACH":"Check");
			method.setTime(new LocalDate().plusDays(i));
			method.setCcy(ccy);
			deliveryMethodList.add(method);
		}
		map.put("deliveryMethodList", deliveryMethodList);
		return map;
	}
	
	
	public static String[] uploadDocument(CommonsMultipartFile fileObj) throws IOException
    {
    	String result[] = {"",""};
       
    	String origFileName = fileObj.getOriginalFilename();
        String docDir = "C:/swapstech/fxstar-edocs/Others";
        //String fileNamePrefix = "LC_" + String.valueOf(System.currentTimeMillis());
        String fileNamePrefix = origFileName.substring(0, origFileName.lastIndexOf("."));
        String fileNameSuffix = origFileName.substring(origFileName.lastIndexOf(".") + 1);
        String fileName = (new StringBuilder()).append(fileNamePrefix).append(".").append(fileNameSuffix).toString();
        
        fileObj.transferTo(new File((new StringBuilder()).append(docDir).append(File.separator).append(fileName).toString()));
        
        result[0] = docDir;
        result[1] = fileName;
        return result;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
