package org.dao;

import org.entity.SaysUser;
import org.entity.SaysVisit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysVisitDaoImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysVisitDao saysVisitdao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysVisitDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        saysVisitdao=(ISaysVisitDao) act.getBean("saysVisitDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysVisitDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
	  public void testfandMySaysVisit(){
	    System.out.println("所有我访问的记录");
		Boolean istest=false;
		if(saysVisitdao.fandMySaysVisit("U002", 1, 2)!=null){
			istest=true;
		}
		assertTrue(istest);
	}
	    public void testfandSaysVisit(){
	        System.out.println("所有的访问信息");
	    	Boolean istest=false;
	    	if(saysVisitdao.fandSaysVisit("U001", 1, 2)!=null){
	    		istest=true;
	    	}
	    	assertTrue(istest);
	    }
	    public void testfandMycountSaysVisit(){
	    	Boolean istest=false;
	      System.out.println("所有的我访问信息的数目");
	    	if(saysVisitdao.countByUserid("U001")>=0){
	    		istest=true;
	    	}
	    	assertTrue(istest);
	    }
	     public void testfandSaysVisits(){
		    Boolean istest=false;
	  System.out.println("所有的访问信息的数目");
		    if(saysVisitdao.countByUserid("U001")>=0){
			   istest=true;
		    }
		    assertTrue(istest);
	      }
	    
	      public void testaddsaysRizhitype(){
		     System.out.println("添加一个访问记录");
		     SaysVisit v = new SaysVisit();
		     SaysUser user = new SaysUser();
		     SaysUser user2 = new SaysUser();
		     user.setUserid("U001");
		     user2.setUserid("U004");
	       	 v.setUserid(user);
		     v.setFromuserid(user2);;
		     saysVisitdao.addSaysVisit(v);;
		     assertTrue(true);
		}
	      public void testupdateVisitIdTime(){
	 	     System.out.println("更新时间");
	 	     SaysVisit v = new SaysVisit();
	 	     v.setVisitid("V001");
	 	     SaysUser user = new SaysUser();
	 	     SaysUser user2 = new SaysUser();
	 	     user.setUserid("U001");
	 	     user2.setUserid("U004");
	        	 v.setUserid(user);
	 	     v.setFromuserid(user2);
	 	     saysVisitdao.updateVisitIdTime(v);
	 	     assertTrue(true);
	 	}
	    public void testfandByVisitId(){
	    	
	    	System.out.println("访问的用户ID查询是否有了访问记录");
		    Boolean istest=false;
		    if(saysVisitdao.fandByVisitId("U002","U001")!=null){
			   istest=true;
		    }
		    assertTrue(istest);
	      }
//      public void testdeleteSaysVisit(){
//       System.out.println("所有我访问的记录");
//     
//	   saysVisitdao.deleteVisitId("2bf1df254adf2bc9014adf2caeab0002");
//	   assertTrue(true);
//      }
      
      
    
}
