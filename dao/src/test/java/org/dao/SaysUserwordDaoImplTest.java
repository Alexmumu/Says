package org.dao;

import org.entity.SaysUser;
import org.entity.SaysUserword;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysUserwordDaoImplTest
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysUserwordDao saysUserwordDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysUserwordDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        saysUserwordDao=(ISaysUserwordDao) act.getBean("saysUserwordDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysUserwordDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testCountAll(){
    	
//    	SaysUserword aa=saysUserwordDao.findSaysUserwordByUserId("U001");
//    	System.out.println(aa.getUserwordcontent());
//    	SaysUserword  suw=new SaysUserword ();
//    	SaysUser sus=new SaysUser();
//    	sus.setUserid("U005");
//    	suw.setUserid(sus);
//    	saysUserwordDao.saveSaysUserword(suw);
//    		istest=true;
    //	saysUserwordDao.deleteById("9b92e2c64ad32a36014ad32a4af30000");
//    	SaysUserword us=new SaysUserword();
//    	us.setUserwordid("UW01");
//    	us.setUserwordcontent("sdsdas");
//    	SaysUser u = new SaysUser();
//    	u.setUserid("U001");
//    	us.setUserid(u);
//    	saysUserwordDao.updateSaysUserword(us);
    	assertTrue(true);
    }
}
