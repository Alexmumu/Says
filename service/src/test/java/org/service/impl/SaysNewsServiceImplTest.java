package org.service.impl;

import org.entity.SaysNews;
import org.entity.SaysUser;
import org.service.ISaysNewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vo.Page;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysNewsServiceImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysNewsService newsService;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysNewsServiceImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext ("applicationContext-service.xml","applicationContext-dao.xml");
        newsService=(ISaysNewsService) act.getBean("saysNewsServiceImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysNewsServiceImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
    	assertTrue(true);
    }
    
    public void testAddNews(){
       	Boolean istest=false;
    	SaysNews news = new SaysNews();
    	news.setNewscontent("RZ04");
    	news.setNewsstatus(3);
    	SaysUser user = new SaysUser();
    	user.setUserid("U006");
    	news.setUserid(user);
    	if(newsService.AddNews(news)!= null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    public void testFindNewsByUser(){
    	Boolean istest=false;
    	Page<SaysNews> page = new Page<SaysNews>();
    	page.setPageNo(1);
    	page.setPageSize(3);
    	if(newsService.FindNewsByUser("U001",page) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
}