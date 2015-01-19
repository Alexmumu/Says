package org.service.impl;



import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.service.ISaysRizhiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysRizhiServiceImplTest extends TestCase{
	
	private ISaysRizhiService srzs;
	private ApplicationContext act;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysRizhiServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        srzs=(ISaysRizhiService) act.getBean("saysRizhiServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysRizhiServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	      public void testfandSaysRizhi()
	       {	
	  	          System.out.println("app");
	  
	  	         SaysUser u = new SaysUser();
	  	         u.setUserid("U001");
	  	         SaysRizhi srz=new SaysRizhi();
	  	         srz.setRizhiuserid(u);
	  	         srz.setRizhistatus(0);
	  	         Page<SaysRizhi> p = new Page<SaysRizhi>();
	  	         p.setPageNo(1);
	  	         p.setPageSize(4);
	             System.out.println(srz+"userid");
	  	         System.out.println(p.getPageNo()+"pageno");
	  	         System.out.println(p.getPageSize()+"pageSize");
	      	     System.out.println(srzs.findSaysRizhi(srz,p));
	  	//ps.saveProvince(p);;
	             assertTrue( true );
	  }
  public void testfandSaysRizhitype()
  {	
	          System.out.println("app");

	         SaysUser u = new SaysUser();
	         u.setUserid("U001");
	         SaysRizhi srz=new SaysRizhi();
	         srz.setRizhiuserid(u);
	         srz.setRizhistatus(0);
	         SaysRizhitype srzt = new SaysRizhitype();
	         srzt.setTypeid("T001");
	         srz.setRizhitype(srzt);
	         Page<SaysRizhi> p = new Page<SaysRizhi>();
	         p.setPageNo(1);
	         p.setPageSize(4);
        System.out.println(srz+"userid");
	         System.out.println(p.getPageNo()+"pageno");
	         System.out.println(p.getPageSize()+"pageSize");
 	     System.out.println(srzs.findRizhitype(srz, p));
	//ps.saveProvince(p);;
        assertTrue( true );
}
	  public void testaddsaysRizhitype(){
	  	System.out.println("添加日志信息");
	  	SaysRizhi rz = new SaysRizhi();
	  	
	  	rz.setRizhiid("RZ01");
	  	rz.setRizhititle("会做饭的女人2");
	  	rz.setRizhicontent("我女朋友会做饭");
	  	SaysUser user = new SaysUser();
	  	user.setUserid("U001");
	  	rz.setRizhiuserid(user);
	  	rz.setRizhistatus(1);
	  	SaysRizhitype rzt = new SaysRizhitype();
	  	rzt.setTypeid("T001");
	  	rz.setRizhitype(rzt);
	  	rz.setRizhinature(0);
	  	srzs.addSaysRizhi(rz);
	  	
	  	assertTrue(true);
	  	}
	  public void testupdatesaysRizhitype(){
		System.out.println("修改日志信息");
		SaysRizhi rz = new SaysRizhi();
		
		rz.setRizhiid("RZ01");
		rz.setRizhititle("会做饭的女人");
		rz.setRizhicontent("我女朋友会做饭");
		SaysUser user = new SaysUser();
		user.setUserid("U001");
		rz.setRizhiuserid(user);
		rz.setRizhistatus(1);
		SaysRizhitype rzt = new SaysRizhitype();
		rzt.setTypeid("T001");
		rz.setRizhitype(rzt);
		rz.setRizhinature(0);
		srzs.updateSaysRizhi(rz);
		
		assertTrue(true);
		}
	   public void testSaysRizhiById(){
	    	Boolean istest=false;
	    	System.out.println("日志ID查询详细信息");
	    	if(srzs.SaysRizhiById("RZ01")!=null){
	    		istest=true;
	    	}
	    	assertTrue(istest);
	    }
	    public void testcountByUserid(){
	    	Boolean istest=false;
	    	System.out.println("日志的总数目");
	    	if(srzs.countByUserid("U001",1)>=0){
	    		istest=true;
	    		System.out.println("数量"+srzs.countByUserid("U001",0));
	       	}
	    	assertTrue(istest);
	    }
	    //有问题
	    public void testdeleteRizhitype(){
			System.out.println("删除日志信息，修改状态");
			srzs.deleteStatus("RZ01", 0);
			assertTrue(true);
			}
	  

}
