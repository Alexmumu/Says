package org.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
public class SaysFriendsDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysFriendsDao saysfriendsdao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysFriendsDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysfriendsdao=(ISaysFriendsDao) act.getBean("saysFriendsDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysFriendsDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    public void testfindbyuseridallSaysFriends(){
    
    	List<SaysFriends> bb=saysfriendsdao.findbyuseridallSaysFriends("U001", 0, 5);
    		
    	System.out.println(bb.size());
    	assertTrue(true);
    }
    
    public void testaddSaysFriends(){
    	Boolean istest=false;
    	System.out.println("fdsfsd");
    	
    	SaysFriends friends=new SaysFriends();
    	
    	friends.setFriendid("FD03");
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U004");
    	friends.setUserid(user);
    	
    	SaysUser user2=new SaysUser();
    	user2.setUserid("U003");
    	friends.setUserfriendid(user2);
    	
    	Serializable af=saysfriendsdao.addSaysFriends(friends);
    	if(af!=null)
    	{
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testdeletedFriendsbyid(){
    	Boolean istest=false;
    	
    	saysfriendsdao.deletedFriendsbyid("2bf1d9004ade2d64014ade2e47930001");
    	System.out.println("删除成功");
    	//assertTrue(istest);
    }
   
	  public void testselectbufriendsbuid(){
		Boolean istest=false;
		
		List info = saysfriendsdao.selectbufriendsbyid("U002");
		System.out.println(info);
		//assertTrue(istest);
	  }

	    public void testcountSaysFriends(){
	  		Boolean istest=false;
	  		
	  		int info = saysfriendsdao.countSaysFriends("U001");
	  		System.out.println(info);
	  		//assertTrue(istest);
	  	  }
    
    
}
