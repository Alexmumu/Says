package org.service.impl;

import org.entity.SaysComments;
import org.entity.SaysUser;
import org.service.ISaysCommentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysCommentsServiceImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysCommentsService commentsService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysCommentsServiceImplTest( String testName )
    {
        super( testName );
        act=ServiceTestUtil.getAct();
        commentsService=(ISaysCommentsService) act.getBean("saysCommentsServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysCommentsServiceImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
    	assertTrue(true);
    }
    
    public void testAddComments(){
    	Boolean istest=false;
    	SaysComments comm = new SaysComments();
    	comm.setCommentcontent("大半夜真烦人！");
    	comm.setCommentsforid("RZ01");
    	comm.setCommentstatus("1");
    	SaysUser user = new SaysUser();
    	user.setUserid("U006");
    	SaysUser userare = new SaysUser();
    	userare.setUserid("U001");
    	comm.setUserid(user);
    	//comm.setUseridare("U001");
    	if(commentsService.addComments(comm)!= null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testFindComments(){
    	Boolean istest=false;
    	Page<SaysComments> page = new Page<SaysComments>();
    	page.setPageNo(1);
    	page.setPageSize(3);
    	if(commentsService.findComments("A001",page,"1") != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testDeleteComments(){
    	Boolean istest=false;
    	if(commentsService.deleteComments(commentsService.getComment("402881ec4ad36d91014ad36da6af0000"))){
    		istest=true;
    	}
    	assertTrue(istest);   	
    }
    
}
