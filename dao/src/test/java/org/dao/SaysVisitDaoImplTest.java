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
		if(saysVisitdao.findMySaysVisit("U002", 1, 2)!=null){
			istest=true;
		}
		assertTrue(istest);
	}
	    public void testfandSaysVisit(){
	        System.out.println("所有的访问信息");
	    	Boolean istest=false;
	    	if(saysVisitdao.findSaysVisit("U001", 1, 2)!=null){
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
	    
	    public void testfandByVisitId(){
	    	
	    	System.out.println("访问的用户ID查询是否有了访问记录");
		    Boolean istest=false;
		    if(saysVisitdao.findByVisitId("U002","U001")!=null){
			   istest=true;
		    }
		    assertTrue(istest);
	      }

      
      
    
}
