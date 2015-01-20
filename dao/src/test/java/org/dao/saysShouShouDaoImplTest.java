package org.dao;

import org.entity.SaysShuoshuo;
import org.springframework.context.ApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class saysShouShouDaoImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysShouShousDao shousDao;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public saysShouShouDaoImplTest(String testName )
    {
        super(testName);
        act=DaoTestUtil.getAct();
        shousDao = (ISaysShouShousDao)act.getBean("saysShouShouDaoImpl");
    }
	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysAlbumDaoTest.class );
    }

 
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    
    public void testfingByID(){
    	this.shousDao.hasShuoByID("S001");
      	assertTrue(true);
       }
}
