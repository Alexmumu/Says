package org.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.HibernateUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {	SessionFactory sf=HibernateUtil.getSessionfactory();
    	Session s =sf.getCurrentSession();
    	Transaction t= s.beginTransaction();
    	System.out.println(City.class);
    	System.out.println();
    	System.out.println(s.createCriteria(City.class).list().size());
    	t.commit();
    	s.close();
        assertTrue( true );
    }
}
