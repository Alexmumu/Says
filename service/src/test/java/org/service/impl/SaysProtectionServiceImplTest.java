package org.service.impl;

import java.util.List;

import org.entity.City;
import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysProtectionService;
import org.service.ISaysUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysProtectionServiceImplTest 
    extends TestCase
{	
	private ISaysProtectionService ps;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysProtectionServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        ps=(ISaysProtectionService) act.getBean("saysProtectionServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysProtectionServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testfindSaysProtectionbyid()
    {	
    	Boolean istest=false;
    	
    	SaysUser u=new SaysUser();
    	u.setUserid("U003");
    	
    	List p=ps.findSaysProtectionbyid(u.getUserid());
    	System.out.println(p.size());
    	if(p.size()==0)
    	{
    		System.out.println("不好意思！您还没有设置密保！");
    	}
    }
    
    
	    public void testaddnewSaysProtection()
	    {	
	    	SaysUser u=new SaysUser();
	    	u.setUserid("U003");
	    	List p=ps.findSaysProtectionbyid(u.getUserid());
	    	System.out.println(p.size());
	    	if(p.size()==0)
	    	{
	    		SaysProtection p1=new SaysProtection();
	    		p1.setQuestionno1("个地方");
	    		p1.setQuestionno2("同一人");
	    		p1.setQuestionno3("太容易");
	    		p1.setAnswerno1("跟黄金");
	    		p1.setAnswerno2("与体育");
	    		p1.setAnswerno3("问问");
	    		p1.setUserid(u);
	    		
	    		ps.addnewSaysProtection(p1);
	    		System.out.println("密保添加成功！");
	    	}else{
	    		System.out.println("您已添加密保，无法再次添加！");
	    	}
	    }
	    
	    
		  public void testupdateSaysProtections()
		  {	
		  	Boolean istest=false;
		  	
		  	SaysProtection p1=new SaysProtection();
		  	p1.setProtectionid("2bf197a04ad8ed09014ad8ed172a0000");
    		p1.setQuestionno1("hghghgh");
    		p1.setQuestionno2("同一人");
    		p1.setQuestionno3("太容易");
    		p1.setAnswerno1("跟黄金");
    		p1.setAnswerno2("与体育");
    		p1.setAnswerno3("问问");
    		
    		SaysUser u=new SaysUser();
	    	u.setUserid("U003");
    		p1.setUserid(u);
    		
    		System.out.println(p1);
    		
    		ps.updateSaysProtections(p1);
		    
		  }
		  
		  public void testyanzhenSaysProtection(){
			  SaysProtection sp=new SaysProtection();			  
			  sp.setQuestionno1("我来自那里？");
			  sp.setAnswerno1("湖北");
			  
			  sp.setQuestionno2("我叫什么？");
			  sp.setAnswerno2("大爷");
			  
			  sp.setQuestionno3("我的爸爸叫什么？");
			  sp.setAnswerno3("二蛋");
			  SaysUser user=new SaysUser();
			  user.setUserid("U001");
			  sp.setUserid(user);
			  boolean istest=false;
			  if(ps.yanzhenSaysProtection(sp)){
			   istest=true;
			  }
			  System.out.println("失败");
			  assertTrue(istest);
		  }
}
