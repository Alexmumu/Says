package org.dao;

import java.util.Date;

import org.entity.SaysAlbum;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SaysAlbumDaoTest extends TestCase{

	
	private ApplicationContext act;
	private ISaysAlbumDao albumDao;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysAlbumDaoTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        albumDao=(ISaysAlbumDao) act.getBean("saysAlbumDaoImpl");
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysAlbumDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testfindByUserId(){
    	Boolean istest=false;
    	if(albumDao.findByUserId("U001", 1, 10,0)!=null){
    		System.out.println(albumDao.findByUserId("U001", 0, 10,0).size());
    		istest=true;
    	}
    	assertTrue(istest);
    }    
//    
//    public void testcountByUserid(){
//    	Boolean istest=false;
//    	if(albumDao.countByUserid("U001", 0)>0){
//    		istest=true;
//    	}
//    	assertTrue(istest);
//    } 
//    public void testaddAlbum(){
//    	Boolean istest=false;
//    	SaysAlbum al=new SaysAlbum();
//    	al.setAlbumid("A003");
//    	al.setAlbumremark("毕业照");
//    	al.setAlbumstatus(1);
//    	al.setAlbumtitle("第三个相册");
//    	SaysUser user=new SaysUser();
//    	user.setUserid("U001");
//    	al.setUserid(user);
//    	if(albumDao.addAlbum(al)!=null){
//    		istest=true;
//    	}
//    	assertTrue(istest);
//    } 
    
//    public void testdelectAlbum(){
//    	Boolean istest=false;
//    	SaysAlbum al=new SaysAlbum();
//    	al.setAlbumid("A002");
//    	al.setAlbumtitle("第two个相册");
//    	SaysUser user=new SaysUser();
//     	user.setUserid("U001");
//     	al.setUserid(user);
//    	albumDao.update(al);
//    	istest=true;
//    	 
//    	assertTrue(istest);
//   } 
    
//    public void testfindAlbumByalbumid(){
//    	Boolean istest=false;
//     	if(albumDao.findAlbumByalbumid("A001")!=null){
// 		istest=true;
// 	}
// 
//    	 
//    	assertTrue(istest);
//    } 
}
