package org.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysFrequestDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysFrequestDao saysfrequestDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysFrequestDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysfrequestDao=(ISaysFrequestDao) act.getBean("saysFrequestDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysFrequestDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    public void testupdateSaysFrequest(){
    	Boolean istest=false;
    	
    	SaysFrequest frequest=new SaysFrequest();
    	
    	frequest.setFrid("F002");
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U002");
    	frequest.setFruser(user);
    	
    	SaysUser user2=new SaysUser();
    	user2.setUserid("U005");
    	frequest.setFruserare(user2);
    	
    	frequest.setFrstatus(1);
    	
    	saysfrequestDao.updateSaysFrequest(frequest);
    		
        System.out.println("成功");
    	//assertTrue(istest);
    }
    
    public void testaddSaysFrequest(){
    	Boolean istest=false;
    	System.out.println("fdsfsd");
    	
    	SaysFrequest frequest=new SaysFrequest();
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U004");
    	frequest.setFruser(user);
    	
    	SaysUser user2=new SaysUser();
    	user2.setUserid("U003");
    	frequest.setFruserare(user2);
    	
    	frequest.setFrstatus(1);
    	
    	Serializable f=saysfrequestDao.addSaysFrequest(frequest);
    	if(f!=null)
    	{
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testdeletedSaysFrequest(){
    	Boolean istest=false;
    	
    	saysfrequestDao.deletedSaysFrequest("2bf1d9004ade2d64014ade2e00f60000");
    	System.out.println("删除成功");
    	//assertTrue(istest);
    }
    
	  public void testselectSaysFrequest(){
		Boolean istest=false;
		
		List aa=saysfrequestDao.selectSaysFrequest("U002", 0, 5);
		System.out.println(aa);
		//assertTrue(istest);
  	  }

	    public void testselectSaysFrequest2(){
	  		Boolean istest=false;
	  		
	  		List ff = saysfrequestDao.selectSaysFrequest2("F001");
	  		System.out.println(ff.size());
	  		//assertTrue(istest);
	    }
    
		  public void testcountSaysFrequest(){
				Boolean istest=false;
				
				int info = saysfrequestDao.countSaysFrequest("U001");
				System.out.println(info);
				//assertTrue(istest);
			  }
    
		  
		    public void testselectbyfruerandfruserare(){
				Boolean istest=false;
				
				SaysFrequest frequest=new SaysFrequest();
				SaysUser us= new SaysUser();
		    	us.setUserid("U001");
		    	SaysUser u= new SaysUser();
		    	u.setUserid("U005");
		    	
		    	frequest.setFruser(us);
		    	frequest.setFruserare(u);
		    	
		    	System.out.println(frequest.getFruser().getUserid());
		    	System.out.println(frequest.getFruserare().getUserid());
		    	
		    	
				List info = saysfrequestDao.selectbyfruerandfruserare(frequest.getFruser().getUserid(), frequest.getFruserare().getUserid());
				System.out.println(info.size());
				//assertTrue(istest);
			  }
		  
}
