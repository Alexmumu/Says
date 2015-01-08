package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysShouShousDao;
import org.entity.SaysShuoshuo;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;

public class SaysShouShouDaoImpl extends AbstractBaseDao<SaysShuoshuo> implements ISaysShouShousDao{
   private static final String FIND_ALL_SHOUSHOU_HQL="from SaysShuoshuo ss where ss.userid.userid=?";
	
	
	@SuppressWarnings("unchecked")
	public List<SaysShuoshuo> findAllShuoShuo(Serializable userid,
			int firstResult, int maxResults) throws DataAccessException {
		  
		return this.findByHql(FIND_ALL_SHOUSHOU_HQL, firstResult, maxResults,new Object[]{userid});
	}


	public Serializable addShouShou(SaysShuoshuo ss) throws DataAccessException {
	   return this.save(ss);
	}


	public void delectShouShou(Serializable shuoid) throws DataAccessException {
		this.deleteById(shuoid);
		
	}


	@Override
	public void updateShouShou(SaysShuoshuo ss) throws DataAccessException {
		 this.update(ss);
		
	}

}
