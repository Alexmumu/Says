package org.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProvinceDaoImplTest extends TestCase {

	private ApplicationContext act;
	private IProvinceDao provincedao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProvinceDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        provincedao=(IProvinceDao) act.getBean("provinceDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProvinceDaoImplTest.class );
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
    	if(provincedao.findProvince()!=null){
    		istest=true;
    	}
    	assertTrue(istest);
    }

}
