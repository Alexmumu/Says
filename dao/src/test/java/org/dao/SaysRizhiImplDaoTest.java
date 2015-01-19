package org.dao;


import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class SaysRizhiImplDaoTest extends TestCase{
	
	private ApplicationContext act;
	private ISaysRizhiDao saysRizhidao;
	
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRizhiImplDaoTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        saysRizhidao=(ISaysRizhiDao) act.getBean("saysRizhiDaoImpl");
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysRizhiImplDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testCountAll(){
    	Boolean istest=false;
    	System.out.println("查询所有的日志并分页");
//    	SaysUser user = new SaysUser(); 
//    	user.setUserid("U001");
    	if(saysRizhidao.findSaysRizhi("U001",1,1,2)!=null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    public void testSaysRizhiById(){
    	Boolean istest=false;
    	System.out.println("日志ID查询详细信息");
    	if(saysRizhidao.SaysRizhiById("RZ01")!=null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    public void testfindRizhitype(){
    	Boolean istest=false;
    	System.out.println("日志类型查询日志并分页");
    	if(saysRizhidao.findRizhitype("U001","T001",1,1,2)!=null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    public void testcountByUserid(){
    	Boolean istest=false;
    	System.out.println("日志的总数目");
    	if(saysRizhidao.countByUserid("U001",1)>=0){
    		istest=true;
    		System.out.println("数量"+saysRizhidao.countByUserid("U001",1));
       	}
    	assertTrue(istest);
    }
	    

   

}
