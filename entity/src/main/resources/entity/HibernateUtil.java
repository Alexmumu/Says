package entity;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory  sessionFactory;
	private static Logger logger=Logger.getLogger(HibernateUtil.class);
	// static块 会在首次类加载的时候执行
	static {
		logger.info("取得sessionFactory");
		Configuration cfg =new Configuration().configure();

		sessionFactory=cfg.buildSessionFactory();
	}
	
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
