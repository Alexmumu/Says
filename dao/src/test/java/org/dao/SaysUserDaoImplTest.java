package org.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysUserDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysUserDao saysuserdao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysUserDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysuserdao=(ISaysUserDao) act.getBean("saysUserDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysUserDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testlogin(){
    	Boolean istest=false;
    	List a = saysuserdao.login("黄英鹏","123");
    	System.out.println(a.size());
    	if(a.size()==0)
    	{
    		assertTrue( istest );
    		System.out.println("失败");
    	}else
    	{
    		istest=true;
    		System.out.println("成功");
    	}
    }
    
    public void testaddSaysuser(){
    	Boolean istest=false;
    	System.out.println("fdsfsd");
    	SaysUser user=new SaysUser();
    	
    	user.setUsername("fg");
    	user.setUserpassword("123");
    	user.setUsernickname("gg");
    	user.setUsersex(0);
    	user.setUserimg("u9.jpg");
    	user.setUsersig("哈哈");
       
    	user.setUserarea("武汉");
    	
    	 Serializable au = saysuserdao.addSaysuser(user);
    	 if(au!=null)
    	 {
    		 istest=true;
    	 }
    	 
    	 assertTrue(istest);
    }
    
    public void testselectSaysuser(){
    	Boolean istest=false;
    	
    	List user = saysuserdao.selectSaysuser("U002");
    System.out.println(user);
    	//assertTrue(istest);
    }
    
    
    public void testupdateSaysUser(){
    	Boolean istest=false;
    	
    	SaysUser user=new SaysUser();
    	
    	user.setUserid("U004");
    	user.setUsername("fg");
    	user.setUserpassword("123");
    	user.setUsernickname("gg");
    	user.setUsersex(0);
    	user.setUserimg("u9.jpg");
    	user.setUsersig("哈哈");
    	
    	user.setUserbirthday(null);
    	user.setUserregisterday(null);
    	
    	user.setUserarea("武汉");

    	//密码、呢称、性别、头像、个人简介、出生年月、所在地区
    	
    	saysuserdao.updateSaysUser(user);
    	System.out.println("修改成功");
    	//assertTrue(istest);
    }
    
    
	  public void testmhcxSaysUser(){
		 Boolean istest=false;
			
		 List user = saysuserdao.mhcxSaysUser("g", 0, 5);
		 System.out.println(user.toString());
			//assertTrue(istest);
	   }
    
	  public void testcountSaysFriends(){
			 Boolean istest=false;
				
			 int user2 = saysuserdao.countSaysFriends("g");
			 System.out.println(user2);
				//assertTrue(istest);
	  }
    
    
		  public void testselectbyusername(){
			Boolean istest=false;
			
			List user = saysuserdao.selectbyusername("hg");
			System.out.println(user.toString());
			//assertTrue(istest);
		  }
    
    
}
