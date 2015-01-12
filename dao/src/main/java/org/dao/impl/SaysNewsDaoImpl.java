package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysNewsDao;
import org.entity.SaysNews;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysNewsDaoImpl extends AbstractBaseDao<SaysNews> implements
		ISaysNewsDao {

	private static final String FIND_NEWSBYUSER = "from SaysNews as news where news.userid.userid = ? order by news.newtime";
	private static final String FIND_NRWS = "select count(*) from SaysNews as news where news.newsid = ?";
	private static final String COUNT_NEWS = "select count(*) from SaysNews as news where news.userid.userid = ?";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysNews> FindNewsByUser(Serializable userid, int firstResult,
			int maxResults) throws DataAccessException {

		return this.findByHql(FIND_NEWSBYUSER, firstResult, maxResults, new Object[]{userid});
		
	}

	@Override
	public Serializable AddNew(SaysNews news) throws DataAccessException {

		return this.save(news);
		
	}

	@Override
	public boolean HasNew(Serializable newsid) throws DataAccessException {

		if(this.countByHql(FIND_NRWS,new Object[]{newsid})!=0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public int CountNews(Serializable userid) throws DataAccessException {

		return this.countByHql(COUNT_NEWS, new Object[]{userid});
		
	}

	
}
