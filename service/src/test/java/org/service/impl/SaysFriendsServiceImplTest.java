package org.service.impl;

import java.util.List;

import org.entity.City;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysFriendsService;
import org.service.ISaysUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysFriendsServiceImplTest 
    extends TestCase
{	
	private ISaysFriendsService fs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysFriendsServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        fs=(ISaysFriendsService) act.getBean("saysFriendsServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysFriendsServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testfindbyuseridallFriends()
    {	
    	SaysFriends ff=new SaysFriends();
    	SaysUser uu=new SaysUser();
    	uu.setUserid("U001");
    	ff.setUserid(uu);
    	
    	Page<SaysFriends> p= new Page<SaysFriends>();
    	p.setPageNo(1);
    	p.setPageSize(5);
    	
    	System.out.println(p.getPageNo()+"ppp"+p.getPageSize());
    	System.out.println(ff.getUserid().getUserid()+"ffff");
    	
    	System.out.println(fs.findbyuseridallFriends(ff.getUserid().getUserid(), p));
    }
    
    
	    public void testaddnewSaysFriends()
	    {	
	    	SaysUser us= new SaysUser();
	    	us.setUserid("U005");
	    	
	    	SaysUser u= new SaysUser();
	    	u.setUserid("U001");
	    	
	    	SaysFriends f=new SaysFriends();
	    	f.setUserid(us);
	    	f.setUserfriendid(u);
	    	
	    	fs.addnewSaysFriends(f);
	    	
	    }
    
//		  public void testdeletedFriends()
//		  {	
//		  	Boolean istest=false;
//		  	SaysFriends f=new SaysFriends();
//		  	f.setFriendid("2bf1d9004ade4bbc014ade4c7acb0001");
//		  	fs.deletedFriends(f.getFriendid());
//		  }
	    
		  public void testselectbufriendsbyidinfo()
		  {	
		  	Boolean istest=false;
		  	SaysFriends f=new SaysFriends();
		  	
		 	SaysUser us= new SaysUser();
	    	us.setUserid("U002");
		  	f.setUserfriendid(us);

		  	List ff=fs.selectbufriendsbyidinfo(f.getUserfriendid().getUserid());
		  	System.out.println(ff);
		  }
    
    
		  public void testcountSaysFriends()
		  {	
		  	Boolean istest=false;
		  	SaysFriends f=new SaysFriends();
		  	
		 	SaysUser us= new SaysUser();
		 	us.setUserid("U001");
		  	f.setUserid(us);
	
		  	int ff=fs.countSaysFriends(f.getUserid().getUserid());
		  	System.out.println(ff);
		  }
		  
		  
}
