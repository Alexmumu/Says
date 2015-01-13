package org.dao;

import org.entity.SaysReply;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysReplyDaoImplTest extends TestCase {
	private ApplicationContext act;
	private ISaysReplyDao replyDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysReplyDaoImplTest( String testName )
    {
        super( testName );
        act=DaoTestUtil.getAct();
        replyDao=(ISaysReplyDao) act.getBean("saysReplyDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysMsgcenterDaoImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    
    public void testFindReplybyCommentid(){
    	Boolean istest=false;
    	if(replyDao.FindReplybyCommentid("C001",1,5,1) != null){
    		System.out.println(replyDao.FindReplybyCommentid("C001",1,1,1).size());
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testFindReplybyReplyare(){
    	Boolean istest=false;
    	if(replyDao.FindReplybyReplyare("RY02",1,5,1) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testAddReply(){
    	Boolean istest=false;
    	SaysReply reply = new SaysReply();
    	reply.setReplycontent("真麻烦！");
    	reply.setCommentid(null);
    	reply.setReplyare("RY02");
    	reply.setReplystatus(2);
    	SaysUser user = new SaysUser();
    	SaysUser userare = new SaysUser();
    	user.setUserid("U003");
    	userare.setUserid("U002");
    	reply.setUserid(user);
    	reply.setUseridare(userare);
    	if(replyDao.AddReply(reply) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    
    
    public void testHasReply(){
    	Boolean istest=false;
    	if(replyDao.HasReply("RY02")){
    		istest=true;
    	}
    	assertTrue(istest);    	
    }
    
}
