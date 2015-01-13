package org.service.impl;


import org.entity.Province;
import org.service.IProvinceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProvinceImplTest extends TestCase{
	
	private IProvinceService ps;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ProvinceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        ps=(IProvinceService) act.getBean("provinceServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProvinceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
    	Province p=new Province();
    	p.setPid(1);
    	p.setPname("上海");
    	System.out.println(ps.findProvince());
    	//ps.saveProvince(p);;
        assertTrue( true );
    }

}
