package org.dao;


import org.entity.SaysNews;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SaysNewsDaoImplTest extends TestCase {

	private ApplicationContext act;
	private ISaysNewsDao newsDao;
	
	public SaysNewsDaoImplTest(String testName) {
		super(testName);
		act=DaoTestUtil.getAct();
		newsDao = (ISaysNewsDao)act.getBean("saysNewsDaoImpl");
	}
	
	 /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SaysNewsDaoImplTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    
    
    public void testFindNewsByUser(){
    	Boolean istest=false;
    	if(newsDao.FindNewsByUser("U001",1,5) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testAddNew(){
    	Boolean istest=false;
    	SaysNews news = new SaysNews();
    	news.setNewscontent("S002");
    	news.setNewsstatus(1);
    	SaysUser user = new SaysUser();
    	user.setUserid("U001");
    	news.setUserid(user);
    	if(newsDao.AddNew(news) != null){
    		istest=true;
    	}
    	assertTrue(istest);
    }
    
    
    public void testHasNew(){
    	Boolean istest=false;
    	if(newsDao.HasNew("N003")){
    		istest=true;
    	}
    	assertTrue(istest);
    }
	
    
    public void testgetNews(){
    	Boolean istest=false;
    	if(newsDao.getNewsIDBynewscontent("2bf1e3824afbca50014afbccd6530000")!=null){
    		System.out.println(newsDao.getNewsIDBynewscontent("2bf1e3824afbca50014afbccd6530000").getNewscontent());
    		istest=true;
    	}
    	assertTrue(istest);
    }

	
}
