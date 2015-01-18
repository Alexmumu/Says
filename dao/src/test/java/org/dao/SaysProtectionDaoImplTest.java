package org.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysProtectionDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysProtectionDao saysprotectionDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysProtectionDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysprotectionDao=(ISaysProtectionDao) act.getBean("saysProtectionDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysProtectionDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    public void testfindSaysProtectionbyuserid(){
    	Boolean istest=false;
    	
    	List<SaysProtection> p=saysprotectionDao.findSaysProtectionbyuserid("U001");
    	System.out.println(p.get(0).getProtectionid());
    	System.out.println(p.size());
    }
    
    public void testaddSaysProtection(){
    	Boolean istest=false;
    	System.out.println("fdsfsd");
    	SaysProtection p=new SaysProtection();
    	
    	p.setQuestionno1("dsfgg");
    	p.setAnswerno1("dfgfg");
    	p.setQuestionno2("dfgfd");
    	p.setAnswerno2("fdgd");
    	p.setQuestionno3("dfg");
    	p.setAnswerno3("dfg");
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U004");
    	p.setUserid(user);
    	
    	Serializable a = saysprotectionDao.addSaysProtection(p);
    	if(a!=null)
    	{
    		istest=true;
    	}
    	assertTrue(istest);
    }
    

    
    public void testupdateSaysProtection(){
    	Boolean istest=false;
    	
     	SaysProtection pt=new SaysProtection();
    	
     	pt.setProtectionid("2bf1f5274ad304ca014ad304de2c0000");
     	
    	pt.setQuestionno1("hahahah");
    	pt.setAnswerno1("hhehehh");
    	pt.setQuestionno2("dfgfd");
    	pt.setAnswerno2("fdgd");
    	pt.setQuestionno3("dfg");
    	pt.setAnswerno3("dfg");
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U004");
    	pt.setUserid(user);
    	
    	
    	saysprotectionDao.updateSaysProtection(pt);
    	System.out.println("修改成功");
    	//assertTrue(istest);
    }
    
    
    
    
    
    
    
    
    
    
}
