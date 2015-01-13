package org.service.impl;

import org.entity.SaysRelay;
import org.entity.SaysUser;
import org.service.ISaysRelayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysRelayServiceImplTest
    extends TestCase
{	
	private ISaysRelayService cs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRelayServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        cs=(ISaysRelayService) act.getBean("saysRelayServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysRelayServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
//    	SaysRelay ars=new SaysRelay();
//    	SaysUser sus=new SaysUser();
//    	sus.setUserid("U005");
//    	ars.setUseridare(sus);
//    	cs.saveSaysRelay(ars);
    	
    	//cs.deleteSaysRelay("2bf1db254ad996bd014ad996c8ac0000");
    	//cs.findByUseridSaysRelay("U002");
    	assertTrue( true );
    }
}
