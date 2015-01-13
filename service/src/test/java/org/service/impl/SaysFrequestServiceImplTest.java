package org.service.impl;

import java.util.List;

import org.entity.City;
import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysFrequestService;
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
public class SaysFrequestServiceImplTest 
    extends TestCase
{	
	private ISaysFrequestService fq;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysFrequestServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        fq=(ISaysFrequestService) act.getBean("saysFrequestServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysFrequestServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testaddnewSaysFrequest()
    {  	
    	SaysFrequest frequest=new SaysFrequest();
    	
    	SaysUser user=new SaysUser();
    	user.setUserid("U003");
    	frequest.setFruser(user);
    	
    	SaysUser user2=new SaysUser();
    	user2.setUserid("U005");
    	frequest.setFruserare(user2);
    	
    	frequest.setFrstatus(1);
    	
    	fq.addnewSaysFrequest(frequest);    	
    }
    
    
//	    public void testdeletedSaysFrequestbyfrid()
//	    {	
//	    	SaysFrequest frequest=new SaysFrequest();
//	    	frequest.setFrid("2bf1d9004ade4bbc014ade4c34390000");
//	    	
//	    	fq.deletedSaysFrequestbyfrid(frequest.getFrid());
//	    }
    
		  public void testselectSaysFrequestall()
		  {	
			    SaysFrequest frequest=new SaysFrequest();
		    	SaysUser uu=new SaysUser();
		    	uu.setUserid("U001");
		    	frequest.setFruser(uu);
		    	
		    	Page<SaysFrequest> p= new Page<SaysFrequest>();
		    	p.setPageNo(1);
		    	p.setPageSize(5);
		    	
		    	System.out.println(p.getPageNo()+"ppp"+p.getPageSize());
		    	System.out.println(frequest.getFruser().getUserid()+"ffff");
		    	
		    	System.out.println(fq.selectSaysFrequestall(frequest.getFruser().getUserid(), p));
		  
		  }
	    
		  public void testsselectSaysFrequestbyid()
		  {	
		  	Boolean istest=false;
		  	SaysFrequest frequest=new SaysFrequest();
		  	frequest.setFrid("F001");

		  	List p=fq.selectSaysFrequestbyid(frequest.getFrid());
		  	System.out.println(p.size());
		  }
    
		  public void testupdateSaysFrequestbyfrstatus()
		  {	
		  	Boolean istest=false;
		  	SaysFrequest frequest=new SaysFrequest();
		  	frequest.setFrid("F002");
	    	SaysUser user=new SaysUser();
	    	user.setUserid("U002");
	    	frequest.setFruser(user);
	    	SaysUser user2=new SaysUser();
	    	user2.setUserid("U005");
	    	frequest.setFruserare(user2);
	    	frequest.setFrstatus(2);
		  	fq.updateSaysFrequestbyfrstatus(frequest);
		  	//System.out.println(p.size());
		  }
		  
		  
		  public void testcountSaysFrequest()
		  {	
		  	Boolean istest=false;
		  	
		  	SaysUser user=new SaysUser();
	    	user.setUserid("U002");
		  	SaysFrequest frequest=new SaysFrequest();
		  	frequest.setFruser(user);

		  	int p=fq.countSaysFrequest(frequest.getFruser().getUserid());
		  	System.out.println(p);
		  }
		  
		  
    		public void selectbyfruerandfruserare2(){
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
		    	
		    	
				List info = fq.selectbyfruerandfruserare2(frequest.getFruser().getUserid(), frequest.getFruserare().getUserid());
				System.out.println(info.size());
				//assertTrue(istest);
			  }
		  
		  
}
