package org.dao;

import org.entity.SaysComments;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysCommentsDaoImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysCommentsDao commentsDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysCommentsDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        commentsDao=(ISaysCommentsDao) act.getBean("saysCommentsDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysCommentsDaoImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    
    
    public void testFindComments(){
    	Boolean istest=false;
    	if(commentsDao.FindComments("A001",1,5,"1") != null){
    		System.out.println(commentsDao.FindComments("A001",1,5,"1").size());
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testAddComments(){
    	Boolean istest=false;
    	SaysComments comm = new SaysComments();
    	comm.setCommentcontent("真麻烦！");
    	comm.setCommentsforid("A001");
    	comm.setCommentstatus("1");
    	SaysUser user = new SaysUser();
    	user.setUserid("U001");
    	SaysUser userare = new SaysUser();
    	userare.setUserid("U002");
    	comm.setUserid(user);
    	comm.setUseridare("U002");
    	if(commentsDao.AddComments(comm) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testHasComment(){
    	Boolean istest=false;
    	if(commentsDao.HasComment("C002")){
    		istest=true;
    	}
    	assertTrue(istest);  	
    }
}
