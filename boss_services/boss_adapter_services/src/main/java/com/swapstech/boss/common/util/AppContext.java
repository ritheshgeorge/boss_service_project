package com.swapstech.boss.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppContext {
	private static ApplicationContext ctx;
	
	public static void setApplicationContext(ApplicationContext applicationContext) { 
		ctx = applicationContext;       
	}
	
	public static ApplicationContext getApplicationContext() {   
		ctx = new GenericXmlApplicationContext("spring-server-beans.xml");
		return ctx;       
	}
}
