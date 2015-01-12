package org.dao;

import org.entity.SaysLeaveword;
import org.entity.SaysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class SaysLeavewordDaoImplTest
    extends TestCase
{	
	private ApplicationContext act;
	private ISaysLeavewordDao saysLeavewordDao;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SaysLeavewordDaoImplTest( String testName )
    {
        super( testName );
        act=new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        saysLeavewordDao=(ISaysLeavewordDao) act.getBean("saysLeavewordDaoImpl");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(SaysLeavewordDaoImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	
        assertTrue( true );
    }
    public void testAll(){
    	Boolean istest=false;
//		测试分页查询留言板信息
//    	if(saysLeavewordDao.findSaysLeavewords(1, 2,"U002","1")!=null){
//    		istest=true;
//    	}
//		测试添加一条留言
//    	if(1==1)
//    	{
//    	SaysLeaveword alw1=new SaysLeaveword();
//    	alw1.setLeavewordcontent("我来留言啦Test3..");
//    	
//    	SaysUser sus4=new SaysUser();
//    	sus4.setUserid("U001");
//    	SaysUser sus5=new SaysUser();
//    	sus5.setUserid("U001");
//    	//alw.getUserid().setUserid("U002");
//    	alw1.setUserid(sus4);
//    	alw1.setFromuserid(sus5);
//    	alw1.setLevewodidstatus(1);
//    	saysLeavewordDao.saveSaysLeaveword(alw1);
//    	istest=true;
//    	}
//		测删除单条留言
//    	if(1==1)
//    	{
//    	saysLeavewordDao.deleteSaysLeaveword("9b92e2c64ad29bc8014ad29bde3a0000");
//    	}
//    	assertTrue(istest);
//		测试查询用户留言板条数   	
//    	if(1==1)
//    	{
//    	saysLeavewordDao.countAllSaysLeaveword("U002","1");
//    	}
    	SaysLeaveword al=saysLeavewordDao.findByLeavewordidSaysLeaveword("LW01");
    	System.out.println(al.getLeavewordcontent());
    	assertTrue(true);
    }
}
