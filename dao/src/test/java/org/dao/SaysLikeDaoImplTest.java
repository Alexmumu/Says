package org.dao;

import java.util.Date;
import java.util.List;

import org.dao.impl.SaysLikeDaoImpl;
import org.entity.SaysLike;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysLikeDaoImplTest
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysLikeDao saysLikeDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysLikeDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysLikeDao=(ISaysLikeDao) act.getBean("saysLikeDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysLikeDaoImplTest.class );
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
//    		SaysUser sus=new SaysUser();
//    		sus.setUserid("U001");
//    		SaysUser sus1=new SaysUser();
//    		sus1.setUserid("U001");
//    		SaysLike al=new SaysLike();	
//    		al.setLikefor("S001");
//    		al.setUserid(sus);
//    		al.setUseridare(sus1);
//    		saysLikeDao.saveSaysLike(al);
//    		istest=true;  
//    	saysLikeDao.deleteSaysLike("9b92e2c64ad2e012014ad2e0256f0000");
//    	saysLikeDao.countByUseridSaysLike("U001");
 //   	List<SaysLike> list=saysLikeDao.findByUseridSaysLike("U001");
 //   	System.out.println(list.size());
    	
    	assertTrue(true);
    }
}
