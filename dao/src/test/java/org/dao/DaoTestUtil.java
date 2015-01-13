package org.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTestUtil {
	private static ApplicationContext act;

	public static ApplicationContext getAct() {
		if(act==null){
	        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		}
		return act;
	}

	
	
}
