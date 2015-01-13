package org.service.impl;

import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.service.ISaysRizhitypeService;
import org.service.ISaysVisitService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysRizhitypeServiceImplTest extends TestCase {
	
	private ISaysRizhitypeService srzts;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRizhitypeServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        srzts=(ISaysRizhitypeService) act.getBean("saysRizhitypeServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysRizhitypeServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
    	SaysRizhitype srzt = new SaysRizhitype();
    	srzt.setTypeid("dfsdf");
    	srzt.setTypename("455");
    	srzts.find("U001",1);
    	 assertTrue( true );
    }
//  public void testaddsaysRizhitype(){
//	System.out.println("添加日志类型");
//	SaysRizhitype rzt = new SaysRizhitype();
//	
//	rzt.setTypename("时装类1");
//	SaysUser user = new SaysUser();
//	user.setUserid("U002");
//	rzt.setUserid(user);
//	rzt.setTypestatus(1);
//	srzts.addRizhitype(rzt);
//	
//	assertTrue(true);
//	}
//  public void testupdatesaysRizhitype(){
//  	System.out.println("修改日志类型");
//  	SaysRizhitype rzt = new SaysRizhitype();
//  	
//  	rzt.setTypeid("2bf1d8b04acefec7014acefed3e40000");
//  	rzt.setTypename("星座类");
//  	SaysUser user = new SaysUser();
//  	user.setUserid("U001");
//  	rzt.setUserid(user);
//  	rzt.setTypestatus(1);
//  	srzts.updataRizhitype(rzt);
//  	
//		assertTrue(true);
//  	}
  //有问题
  public void testdeletesaysRizhitype(){
	  	System.out.println("删除日志类型");
	  	SaysRizhitype rzt = new SaysRizhitype();
	  	//T001是不可删除的
	  	rzt.setTypeid("4028abe64add5055014add510c310000");
	  	SaysUser user = new SaysUser();
	  	user.setUserid("U001");
	  	rzt.setUserid(user);
	  	srzts.deleteRizhitype(rzt);
			assertTrue(true);
	  	}
  public void testcountByUserid(){
	  	System.out.println("查数目");
	 
	  	srzts.countByUserid("U001", 1);
			assertTrue(true);
	  	}
	  
  

}
