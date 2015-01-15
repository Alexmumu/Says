package org.service.impl;

import org.entity.SaysReply;
import org.entity.SaysUser;
import org.service.ISaysReplyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysReplyServiceImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysReplyService replyService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysReplyServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        replyService=(ISaysReplyService) act.getBean("saysReplyServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysReplyServiceImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
    	assertTrue(true);
    }
    
    public void testAddReply(){
       	Boolean istest=false;
    	SaysReply reply = new SaysReply();
    	reply.setReplycontent("大半夜真烦！");
    	reply.setCommentid(null);
    	reply.setReplyare("402881ec4ad37c5b014ad37c71690000");
    	reply.setReplystatus(2);
    	SaysUser user = new SaysUser();
    	SaysUser userare = new SaysUser();
    	user.setUserid("U006");
    	userare.setUserid("U003");
    	reply.setUserid(user);
    	reply.setUseridare(userare);
    	if(replyService.addReply(reply)!= null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testFindReplybyCommentid(){
    	Boolean istest=false;
    	Page<SaysReply> page = new Page<SaysReply>();
    	page.setPageNo(1);
    	page.setPageSize(3);
    	if(replyService.findReplybyCommentid("C001",page,1) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testFindReplybyReplyare(){
    	Boolean istest=false;
    	Page<SaysReply> page = new Page<SaysReply>();
    	page.setPageNo(1);
    	page.setPageSize(3);
    	if(replyService.findReplybyReplyare("RY01",page,1) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testDeleteReply(){
    	Boolean istest=false;
    	if(replyService.deleteReply(replyService.getReply("402881ec4ad46d7a014ad46d919a0000"))){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
}
