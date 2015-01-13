package org.service.impl;


import java.util.List;

import org.entity.SaysLeaveword;
import org.entity.SaysUser;
import org.service.ISaysLeavewordService;
import org.vo.Page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysLeavewordServiceImplTest
    extends TestCase
{	
	private ISaysLeavewordService ls;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysLeavewordServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        ls=(ISaysLeavewordService) act.getBean("saysLeavewordServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysLeavewordServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
//   	List<SaysLeaveword> list=ls.findAllSaysLeaveword(1, 2, "U001","1");
    	SaysLeaveword alw=new SaysLeaveword();
    	SaysUser sus=new SaysUser();
    	sus.setUserid("U001");
    	alw.setLevewodidstatus(1);
    	alw.setUserid(sus);
    	Page page=new Page();
    	page.setPageNo(2);
    	page.setPageSize(2);
    	
    	Page<SaysLeaveword> ss=ls.findAllSaysLeaveword(page, alw);
 //   	System.out.println(ss.getResult().get(0));
//  	SaysLeaveword alw=new SaysLeaveword();
//    	alw.setLeavewordcontent("qwertyuio");
//    	ls.saveSaysLeaveword(alw);
 //   	ls.deleteSaysLeaveword("2bf1ec2a4ad80f0b014ad80f17620000");
    	//ls.countAllSaysLeaveword("U001", 1);
        assertTrue( true );
    }
}
