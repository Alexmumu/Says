package org.service.impl;

import org.entity.Province;

import org.entity.SaysUser;
import org.entity.SaysVisit;
import org.service.IProvinceService;
import org.service.ISaysVisitService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysVisvitServiceImplTest extends TestCase{
	
	private ISaysVisitService svs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysVisvitServiceImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext ("applicationContext-service.xml","applicationContext-dao.xml");
        System.out.println(act);
        svs=(ISaysVisitService) act.getBean("saysVisvitServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysVisvitServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void findSaysVisitsUseridByAndPage()
    {	
    	System.out.println("查询访问我的记录并分页");
    
    	SaysUser u = new SaysUser();
    	u.setUserid("U001");
    	SaysVisit sv=new SaysVisit();
    	sv.setUserid(u);
    	Page<SaysVisit> p = new Page<SaysVisit>();
    	p.setPageNo(1);
    	p.setPageSize(3);
     	System.out.println(sv+"userid");
    	System.out.println(p.getPageNo()+"pageno");
    	System.out.println(p.getPageSize()+"pageSize");
    	System.out.println(svs.findSaysVisitsUseridByAndPage(sv, p));
    	//ps.saveProvince(p);;
        assertTrue( true );
    }
    
    
    public void testApp2()
    {	
    	System.out.println("查询我看谁的访问记记录并分页");
    
    	SaysUser u = new SaysUser();
    	u.setUserid("U001");
    	SaysVisit sv=new SaysVisit();
    	sv.setFromuserid(u);
    	Page<SaysVisit> p = new Page<SaysVisit>();
    	p.setPageNo(0);
    	p.setPageSize(3);
     	System.out.println(sv+"userid");
    	System.out.println(p.getPageNo()+"pageno");
    	System.out.println(p.getPageSize()+"pageSize");
    	System.out.println(svs.fandMySaysVisit(sv,p));
    	//ps.saveProvince(p);;
        assertTrue( true );
    }

    public void testadd()
    {	
    	System.out.println("添加一条访问记录");
    	SaysVisit sv=new SaysVisit();
        SaysUser u = new SaysUser();
    	u.setUserid("U001");
        SaysUser u1 = new SaysUser();
        u1.setUserid("U006");
        
        sv.setUserid(u);
        sv.setFromuserid(u1);
        
    	svs.addSaysVisit(sv);
        assertTrue( true );
    }
    public void tsetcountByUserid(){
    	System.out.println("countByUserid");
    
    	
    	svs.countByUserid("U001");
    	assertTrue( true );
    	
    	
    }
    public void tsetMycountByUserid(){
    	System.out.println("MycountByUserid");
    	svs.countMyByUserid("U001");
    	assertTrue( true );

    }
//    public void testdeleteVisitId(){
//    	svs.deleteVisitId("2bf1e1e44ad97bbf014ad97bd5ba0000");
//    }
    
    
}
