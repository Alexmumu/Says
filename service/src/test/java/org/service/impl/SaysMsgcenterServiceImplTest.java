package org.service.impl;


import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.service.ISaysMsgcenterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysMsgcenterServiceImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysMsgcenterService msgcenterService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysMsgcenterServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        msgcenterService=(ISaysMsgcenterService) act.getBean("saysMsgcenterServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysMsgcenterServiceImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
    	assertTrue(true);
    }
    
    public void testAddMsg(){
    	Boolean istest=false;
 	   SaysMsgcenter msg = new SaysMsgcenter();
 	   msg.setMcfromid("S002");
 	   msg.setMctype(4);
 	   msg.setMcstatus(1);
 	   SaysUser user = new SaysUser();
 	   user.setUserid("U001");
 	   msg.setUserid(user);
 		if(msgcenterService.AddMsg(msg)!=null){
 		   		istest=true;
 		   	}
 		assertTrue(istest);
    }
    
    
    public void testFindNewMsg(){
    	Boolean istest=false;
    	int a = msgcenterService.FindNewMsg("U001");
    	System.out.println("------------a-----------");
    	System.out.println("a="+a);
    	if(a>0){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testFindMsgByUser(){
    	Boolean istest=false;
    	Page<SaysMsgcenter> page = new Page<SaysMsgcenter>();
    	page.setPageNo(1);
    	page.setPageSize(2);
    	if(msgcenterService.FindMsgByUser("U001",page) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
}
