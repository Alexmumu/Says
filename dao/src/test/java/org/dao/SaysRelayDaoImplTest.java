package org.dao;

import java.util.List;

import org.entity.SaysRelay;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysRelayDaoImplTest
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysRelayDao saysRelayDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRelayDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        saysRelayDao=(ISaysRelayDao) act.getBean("saysRelayDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysRelayDaoImplTest.class );
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
//    	SaysRelay sr=new SaysRelay();
//    	SaysUser sus=new SaysUser();
//    	sus.setUserid("U002");
//    	sr.setUseridare(sus);
//    	saysRelayDao.saveSaysRelay(sr);
//    	saysRelayDao.countByUseridSaysRelay("U001");
//    	saysRelayDao.deleteSaysRelay("2bf1f1b84ad6dc15014ad6dc2b200000");
    	List<SaysRelay> list=saysRelayDao.findByUseridSaysRelay("U002");
    	System.out.println(list.size());
    	assertTrue(true);
    }
}
