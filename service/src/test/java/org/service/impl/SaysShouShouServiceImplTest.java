package org.service.impl;

import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysPhotoService;
import org.service.IsaysShouShouService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysShouShouServiceImplTest extends TestCase{
	private IsaysShouShouService ss;
	private ApplicationContext act;
	
	   /**
  * Create the test case
  *
  * @param testName name of the test case
  */
 public SaysShouShouServiceImplTest( String testName )
 {
     super( testName );
     act=ServiceTestUtil.getAct();
     System.out.println(act);
     ss=(IsaysShouShouService) act.getBean("saysShouShouServiceImpl");
 }

 /**
  * @return the suite of tests being tested
  */
 public static Test suite()
 {
     return new TestSuite(SaysShouShouServiceImplTest.class );
 }

 /**
  * Rigourous Test :-)
  */
 public void testApp()
 {	
     assertTrue( true );
 }

// 
//  public void testaddShouShou(){
//  	Boolean istest=false;
//   	SaysShuoshuo ss1=new SaysShuoshuo();
//   	    ss1.setShuocontent("第一次发表说说");
//   	    ss1.setShuonature(0);
//    	ss1.setShuostatus(1);
//    	SaysUser user=new SaysUser();
//   	    user.setUserid("U001");
//    	ss1.setUserid(user);
//    	if(ss.addShouShou(ss1)!=null){
// 		istest=true;
//   	 assertTrue(istest);
//   }
//  }
//
// public void testupdateShouShou(){
//	 	Boolean istest=false;
//	  	SaysShuoshuo ss1=new SaysShuoshuo();
//	  	ss1.setShuoid("2c9ba3814ad3fada014ad3faf03a0000");
//	  	ss1.setShuocontent("今天星期六");
//	  	ss1.setShuonature(0);
//	  	ss1.setShuostatus(1);
//	  	SaysUser user=new SaysUser();
//	  	user.setUserid("U001");
//	  	ss1.setUserid(user);
//	   ss.updateShouShou(ss1);
//			istest=true;
//	  	 assertTrue(istest);
//	  
//	 }
 
 
// public void testfindAllShuoShuo()
// {
// 	Boolean istest=false;
//   SaysShuoshuo ss1=new SaysShuoshuo();
//   ss1.setShuostatus(1);
//   SaysUser user=new SaysUser();
//   user.setUserid("U001");
//   ss1.setUserid(user);
//    Page<SaysShuoshuo> page=new Page<SaysShuoshuo>();
// 	page.setPageNo(1);
// 	page.setPageSize(2);
//    if(ss.findAllShuoShuo(ss1, page, ss1.getShuostatus())!=null){
// 		istest=true;
// 	}
// 	assertTrue(istest);
// }
 
}
