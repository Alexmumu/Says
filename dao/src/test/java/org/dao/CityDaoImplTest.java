package org.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CityDaoImplTest 
    extends TestCase
{	
	private ApplicationContext act;
	private ICityDao citydao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CityDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
      citydao=(ICityDao) act.getBean("cityDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CityDaoImplTest.class );
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
    	if(citydao.countAll()>0){
    		istest=true;
    	}
    	assertTrue(istest);
    }
}
