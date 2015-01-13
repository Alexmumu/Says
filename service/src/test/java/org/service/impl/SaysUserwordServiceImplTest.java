package org.service.impl;

import org.entity.City;
import org.entity.SaysUser;
import org.entity.SaysUserword;
import org.service.ICityService;
import org.service.ISaysUserwordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysUserwordServiceImplTest 
    extends TestCase
{	
	private ISaysUserwordService cs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysUserwordServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        cs=(ISaysUserwordService) act.getBean("saysUserwordServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysUserwordServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
    	SaysUser sus=new SaysUser();
    	sus.setUserid("U006");
    	SaysUserword su=new SaysUserword();
   	su.setUserwordcontent("aaaa");
//    	su.setUserwordid("2bf1db254ad99f9a014ad99fa5b50000");
    	su.setUserid(sus);
//    	cs.updateSaysUserword(su);
    	cs.saveSaysUserword(su);
        assertTrue( true );
    }
}
