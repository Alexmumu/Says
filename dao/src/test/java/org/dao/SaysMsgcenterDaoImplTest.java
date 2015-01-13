package org.dao;

import java.sql.Timestamp;

import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysMsgcenterDaoImplTest extends TestCase {
	private ApplicationContext act;
	private ISaysMsgcenterDao msgcenterDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysMsgcenterDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        msgcenterDao=(ISaysMsgcenterDao) act.getBean("saysMsgcenterDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysMsgcenterDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testFindMsgByUser(){
    	Boolean istest=false;
    	if(msgcenterDao.FindMsgByUser("U001",1,5) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    public void testFindNewMsg(){
    	Boolean istest=false;
    	int a = msgcenterDao.FindNewMsg("U001");
    	System.out.println("------------a-----------");
    	System.out.println("a="+a);
    	if(a>0){
    		istest=true;
    	}
    	assertTrue(istest);
    }
   public void  testAddMsg(){
	   Boolean istest=false;
	   SaysMsgcenter msg = new SaysMsgcenter();
	   msg.setMcid("M002");
	   msg.setMcfromid("S001");
	   msg.setMctype(4);
	   msg.setMcstatus(1);
	   msg.setMsctime(new Timestamp(20120110));
	   SaysUser user = new SaysUser();
	   user.setUserid("U001");
	   msg.setUserid(user);
	   msgcenterDao.AddMsg(msg);
		if(msgcenterDao.FindNewMsg("U001")>0){
		   		istest=true;
		   	}
		assertTrue(istest);
   }
   
   
   public void testhasMsg(){
   	Boolean istest=false;
   	if(msgcenterDao.hasMsg("M002")){
   		istest=true;
   	}
   	assertTrue(istest);   
   }
}
