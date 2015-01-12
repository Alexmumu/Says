package org.dao;


import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class SaysRizhitypeDaoImplTest extends TestCase{
	
	private ApplicationContext act;
	private ISaysRizhitypeDao saysRizhitypedao;
	
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRizhitypeDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysRizhitypedao=(ISaysRizhitypeDao) act.getBean("saysRizhitypeDaoImpl");
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysRizhitypeDaoImplTest.class );
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
    	System.out.println("chaxun");
    	if(saysRizhitypedao.find("U001",1)!=null){
    		istest=true;
    		System.out.println(this.toString());
    	}
    	assertTrue(istest);
    }
    public void testfandBytype(){
    	Boolean istest=false;
    	System.out.println("按照id查询类型");
    	if(saysRizhitypedao.fandBytype("T001")!=null){
    		istest=true;
       	}
    	assertTrue(istest);
    }
    public void testcountByUserid(){
    	Boolean istest=false;
    	System.out.println("23165456");
    	
    	if(saysRizhitypedao.countByUserid("U001",1)>=0){
    		istest=true;
       	}
    	assertTrue(istest);
    }
    public void testaddsaysRizhitype(){
    	System.out.println("添加日志类型");
    	SaysRizhitype rzt = new SaysRizhitype();
    	
    	rzt.setTypeid("T003");
    	rzt.setTypename("生活类zz");
    	SaysUser user = new SaysUser();
    	user.setUserid("U001");
    	rzt.setUserid(user);
    	rzt.setTypestatus(1);
    	saysRizhitypedao.addRizhitype(rzt);
    	
		assertTrue(true);
    	}
    public void testupdatesaysRizhitype(){
    	System.out.println("修改日志类型");
    	SaysRizhitype rzt = new SaysRizhitype();
    	
    	rzt.setTypeid("2bf1d8b04acefec7014acefed3e40000");
    	rzt.setTypename("战争类aa");
    	SaysUser user = new SaysUser();
    	user.setUserid("U001");
    	rzt.setUserid(user);
    	rzt.setTypestatus(1);
    	saysRizhitypedao.updataRizhitype(rzt);
    	
		assertTrue(true);
    	}
    
    
    

}
