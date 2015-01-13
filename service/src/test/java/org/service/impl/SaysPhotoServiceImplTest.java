package org.service.impl;

import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysPhotoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysPhotoServiceImplTest extends TestCase{
	private ISaysPhotoService ph;
	private ApplicationContext act;
	
	   /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysPhotoServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        System.out.println(act);
        ph=(ISaysPhotoService) act.getBean("saysPhotoServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysPhotoServiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
 
//    public void testaddPhotoIntoAlbum(){
//    	Boolean istest=false;
//     	SaysPhoto ph1=new SaysPhoto();
//         ph1.setPhotoremark("毕业照");
//         ph1.setPhotosrc("p1.jpg");
//         ph1.setPhotostatus("1");
//         ph1.setPhototype(0);
//         SaysUser user=new SaysUser();
//         user.setUserid("U001");
//        SaysAlbum al=new SaysAlbum();
//        al.setAlbumid("A001");
//         ph1.setAlbumid(al);
//         ph1.setUserid(user);
//     	 if(ph.addPhotoIntoAlbum(ph1)!=null){
//     		 istest=true;
//     	 }
//     	 assertTrue(istest);
//     }
// 
//    public void testupdatePhoto(){
//    	Boolean istest=false;
//    	SaysPhoto ph1=new SaysPhoto();
//    	ph1.setPhotoid("P001");
//        ph1.setPhotoremark("hello");
//        ph1.setPhotosrc("p1.jpg");
//        ph1.setPhotostatus("1");
//        ph1.setPhototype(0);
//        SaysUser user=new SaysUser();
//        user.setUserid("U001");
//       SaysAlbum al=new SaysAlbum();
//       al.setAlbumid("A001");
//        ph1.setAlbumid(al);
//        ph1.setUserid(user);
//    	 ph.updatePhoto(ph1) ;
//    		 istest=true;
//    	 
//    	 assertTrue(istest);
//    }
    
    public void testfindPhotoByAlbumId()
    {
    	Boolean istest=false;
    	SaysAlbum al1=new SaysAlbum();
    	al1.setAlbumid("A001");
        Page<SaysPhoto> page=new Page<SaysPhoto>();
    	page.setPageNo(1);
    	page.setPageSize(2);
        SaysPhoto ph1=new SaysPhoto();
        ph1.setAlbumid(al1);
        ph1.setPhotostatus("1");
    	if(ph.findPhotoByAlbumId(ph1, page, ph1.getPhotostatus())!=null){
    		istest=true;
    	}
    	assertTrue(istest);
    }

}
