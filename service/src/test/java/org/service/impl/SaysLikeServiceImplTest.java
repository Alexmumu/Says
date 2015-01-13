package org.service.impl;


import java.util.List;

import org.entity.SaysLike;
import org.entity.SaysUser;
import org.service.ISaysLikeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysLikeServiceImplTest 
    extends TestCase
{	
	private ISaysLikeService cs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysLikeServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        cs=(ISaysLikeService) act.getBean("saysLikeServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysLikeServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
    	SaysLike al=new SaysLike();
    	SaysUser sus=new SaysUser();
    	sus.setUserid("U001");
    	SaysUser sus1=new SaysUser();
    	sus1.setUserid("U005");  	
    	al.setUserid(sus);
    	al.setUseridare(sus1);
    	al.setLikefor("S001");
    	boolean aa=cs.saveSaysLike(al);
    	if(aa==false)
    		System.out.println("取消点赞了");
    	else
    		System.out.println("你点赞了");
//    	cs.deleteSaysLike("2bf1db254ad987f2014ad987fe140000");
//    	cs.countByUseridSaysLike("U001");
 //   	cs.findByUseridSaysLike("U001");
    	//int i=cs.findByUseridToUseridareForLikeforSaysLike("S001", "U001", "U001");
    	//System.out.println(i);
//    	List<SaysLike> list=cs.findByUseridSaysLike("U001");
 //   	List<SaysLike> list=cs.findByUseridareSaysLike("U001");
  //  	System.out.println(list.size());
    	assertTrue(true);
    }
}
