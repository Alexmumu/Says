package org.dao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class SaysPhotoDaoTest extends TestCase{
	
	private ApplicationContext act;
	private ISaysPhotoDao photoDao;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysPhotoDaoTest(String testName )
    {
        super(testName);
        act=DaoTestUtil.getAct();
        photoDao=(ISaysPhotoDao) act.getBean("saysPhotoDaoImpl");
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
    
    public void testfindPhotoByAlbumId(){
    	Boolean istest=false;
     	if(photoDao.findPhotoByAlbumId("A001", 1, 2, "1")!=null){
 		istest=true;
 	}
 
    	 
    	assertTrue(istest);
    } 
  

}
