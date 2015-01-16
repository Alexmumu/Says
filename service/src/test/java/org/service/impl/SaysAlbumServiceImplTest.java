package org.service.impl;

import org.entity.City;
import org.entity.SaysAlbum;
import org.entity.SaysUser;
import org.service.ICityService;
import org.service.ISaysAlbumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysAlbumServiceImplTest extends TestCase{
	
	private ISaysAlbumService al;
    private ApplicationContext act;
	
	   /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysAlbumServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        al=(ISaysAlbumService) act.getBean("saysAlbumServiceImpl");
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysAlbumServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    
//    public void testfindByUserId()
//    {
//    	Boolean istest=false;
//    	SaysAlbum al1=new SaysAlbum();
//    	al1.setAlbumstatus(0);
//    	SaysUser user=new SaysUser();
//    	Page<SaysAlbum> page=new Page<SaysAlbum>();
//    	page.setPageNo(1);
//    	user.setUserid("U001");
//    	al1.setUserid(user);
//    	if(al.findByUserId(al1, page,0)!=null){
//    		istest=true;
//    	}
//    	assertTrue(istest);
//    }
    
//     public void testaddAlbum(){
//     	Boolean istest=false;
//     	SaysAlbum sal= new SaysAlbum();
//     	sal.setAlbumremark("我的美照");
//     	sal.setAlbumstatus(1);
//     	sal.setAlbumtitle("第四个相册");
//     	SaysUser user=new SaysUser();
//     	user.setUserid("U001");
//     	sal.setUserid(user);
//     	if(al.addAlbum(sal)!=null){
//     		istest=true;
//     	}
//     	assertTrue(istest);
//     }
//    
//    
//     public void testupdateAlbum(){
//     	Boolean istest=false;
//     	SaysAlbum sal= new SaysAlbum();
//     	sal.setAlbumid("4028ab2d4acdb556014acdb633880000");
//     	sal.setAlbumremark("xy");
//     	sal.setAlbumstatus(1);
//     	sal.setAlbumtitle("第四个相册");
//     	SaysUser user=new SaysUser();
//     	user.setUserid("U001");
//     	sal.setUserid(user);
//     	 al.updateAlbum(sal);
//     		istest=true;
//      
//     	assertTrue(istest);
//    }
//    
//    public void testcountByUserid(){
//    	Boolean istest=false;
//  
//    	 if(al.countByUserid("U001", 1)>0){
//    		 istest=true;
//    	 }
//    	 assertTrue(istest);
//    }
    
//    public void testfindByUserId()
//    {
//    	Boolean istest=false;
//         al.delectAlbum("A002","4028ab2d4acdb556014acdb633880000");
//    		istest=true;
//    	   assertTrue(istest);
//    }

}
