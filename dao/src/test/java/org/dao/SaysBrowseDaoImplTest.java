package org.dao;

import java.util.List;

import org.entity.SaysBrowse;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysBrowseDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysBrowseDao saysBrowseDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysBrowseDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysBrowseDao=(ISaysBrowseDao) act.getBean("saysBrowseDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysBrowseDaoImplTest .class );
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
    	//saysBrowseDao.findSaysBrowseByitem("S001");
    	//saysBrowseDao.countByUseridSaysBrowse("U001");
//    	SaysUser sus=new SaysUser();
//  	    sus.setUserid("U003");
//  	    SaysUser sus1=new SaysUser();
//  	    sus1.setUserid("U002");
//    	SaysBrowse sb=new SaysBrowse();
//    	sb.setBrowseid("B003");
//    	sb.setBrowsefor("s001");
//   	    sb.setUserid(sus);
//   	    sb.setUseridare(sus1);
//    	saysBrowseDao.updateSaysBrowse(sb);
//    	saysBrowseDao.saveSaysBrowse(sb);
//    	saysBrowseDao.deleteSaysBrowse("9b92e2c64ad309f8014ad30a0c3b0000");
   	//List<SaysBrowse> list=saysBrowseDao.findSaysBrowseByitem("S001","U001");
   	List<SaysBrowse> list=saysBrowseDao.findSaysBrowse(1,2, "S001","U001");
  	System.out.println(list.size());
    	assertTrue(true);
    }
}
