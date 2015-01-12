package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.entity.City;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysUserService;
import org.vo.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysUserServiceImplTest 
    extends TestCase
{	
	private ISaysUserService suser;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysUserServiceImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext ("applicationContext-service.xml","applicationContext-dao.xml");
        System.out.println(act);
        suser=(ISaysUserService) act.getBean("saysUserServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysUserServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testloginuser()
    {	
    	Boolean istest=false;
    	
    	SaysUser u= new SaysUser();
    	u.setUsername("fg");
    	u.setUserpassword("123");
    	
    	List a = suser.loginuser(u.getUsername(), u.getUserpassword());
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
    
    
	    public void testaddnewSaysuser()
	    {	
	    	Boolean istest=false;
	    	SaysUser us= new SaysUser();
	    	us.setUsername("dfg");
	    	us.setUserpassword("123");
	    	us.setUsernickname("gg");
	    	us.setUsersex(0);
	    	us.setUserimg("u9.jpg");
	    	us.setUsersig("哈哈");
	    	us.setUserarea("武汉");

	    	Serializable as = suser.addnewSaysuser(us);
	    	
	    }
    
		  public void testselectSaysuserbyid()
		  {	
		  	Boolean istest=false;
		  	SaysUser u= new SaysUser();
		  	u.setUserid("U002");
		  	
		  	List c=suser.selectSaysuserbyid(u.getUserid());
		  	System.out.println(c);
		  }
	    
		  public void testupdateSaysUserinfo()
		  {	
		  	Boolean istest=false;
		  	
		  	SaysUser us= new SaysUser();
		  	us.setUserid("U004");
		  	us.setUsername("hg");
		  	us.setUserpassword("123");
		  	us.setUsernickname("gg");
		  	us.setUsersex(0);
		  	us.setUserimg("u9.jpg");
		  	us.setUsersig("哈哈");
		  	us.setUserbirthday(null);
		  	us.setUserregisterday(null);
		  	us.setUserarea("武汉");
		  	
		    suser.updateSaysUserinfo(us);
		  }
    
	    public void testmhcxSaysUserinfo()
	    {	
	    	SaysUser uu=new SaysUser();
	    	uu.setUsername("g");
	    	
	    	Page<SaysUser> p= new Page<SaysUser>();
	    	p.setPageNo(1);
	    	p.setPageSize(5);
	    	
	    	System.out.println(p.getPageNo()+"ppp"+p.getPageSize());
	    	System.out.println(uu.getUsername()+"ffff");
	    	
	    	System.out.println(suser.mhcxSaysUserinfo(uu.getUsername(), p));
	    }
    
    
	    public void testcountSaysFriendssl()
		  {	
		  	Boolean istest=false;
		 	SaysUser us= new SaysUser();
		 	us.setUsername("y");

		  	int ff=suser.countSaysFriendssl(us);
	
		  	System.out.println(ff);
		  }
	   
	    
		  public void testselectbyname()
		  {	
		  	Boolean istest=false;
		  	SaysUser u= new SaysUser();
		  	u.setUsername("hg");
		  	List c=suser.selectbyname(u.getUsername());
		  	System.out.println(c);
		  }
		  
		  
}
