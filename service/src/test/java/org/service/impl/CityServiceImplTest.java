package org.service.impl;

import org.entity.City;
import org.service.ICityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CityServiceImplTest 
    extends TestCase
{	
	private ICityService cs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CityServiceImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext ("applicationContext-service.xml","applicationContext-dao.xml");
        System.out.println(act);
        cs=(ICityService) act.getBean("cityServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CityServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
    	City c=new City();
    	c.setCid(888);
    	c.setCname("通山县22");
    	System.out.println(cs.findAllCity());
    	cs.saveCity(c);
        assertTrue( true );
    }
}
