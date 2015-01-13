package org.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTestUtil {
	private static  ApplicationContext act;

	public static ApplicationContext getAct() {
		if(act==null){
	        act=new ClassPathXmlApplicationContext("applicationContext-service.xml","applicationContext-dao.xml");
		}
		return act;
	}
}
