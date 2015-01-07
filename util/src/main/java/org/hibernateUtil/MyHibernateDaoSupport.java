package org.hibernateUtil;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
@Component
public abstract class MyHibernateDaoSupport extends HibernateDaoSupport {
	/**
	 * 继承HibernateDaoSupport 
	 * 绕一下 这样就可以使用注解来配置依赖关系 
	 * @param sessionFactory
	 */
	@Autowired
	public final void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
}
