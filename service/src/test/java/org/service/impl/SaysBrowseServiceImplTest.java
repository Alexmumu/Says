package org.service.impl;

import org.entity.City;
import org.entity.SaysBrowse;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysBrowseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysBrowseServiceImplTest
    extends TestCase
{	
	private ISaysBrowseService bs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysBrowseServiceImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext ("applicationContext-service.xml","applicationContext-dao.xml");
        System.out.println(act);
        bs=(ISaysBrowseService) act.getBean("saysBrowseServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysBrowseServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
//    	SaysBrowse bss=new SaysBrowse();
//    	SaysUser sus=new SaysUser();
//    	sus.setUserid("U001");
//    	SaysUser sus1=new SaysUser();
//    	sus1.setUserid("U002");
//    	
//    	bss.setUserid(sus);
//    	bss.setUseridare(sus1);
//    	bss.setBrowsefor("rz01");
//    	bs.saveSaysBrowse(bss);
//    	bs.deleteSaysBrowse("9b92f8d84ad83293014ad8329ea90000");
 //   	bs.countByUseridSaysBrowse("U001");
    	bs.findSaysBrowseByitem("S001", "U001");
        assertTrue(true);
    }
}
