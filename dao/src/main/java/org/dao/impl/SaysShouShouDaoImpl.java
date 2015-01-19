package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysShouShousDao;
import org.entity.SaysShuoshuo;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysShouShouDaoImpl extends AbstractBaseDao<SaysShuoshuo> implements ISaysShouShousDao{
   private static final String FIND_ALL_SHOUSHOU_HQL="from SaysShuoshuo ss where ss.userid.userid=? and shuostatus!=? order by shuodate desc";
	
	
	@SuppressWarnings("unchecked")
	public List<SaysShuoshuo> findAllShuoShuo(Serializable userid,
			int firstResult, int maxResults,int shuostatus) throws DataAccessException {
		  
		return this.findByHql(FIND_ALL_SHOUSHOU_HQL, firstResult, maxResults,new Object[]{userid,shuostatus});
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


	@Override
	public int countShouShouByUserId(Serializable userid, int shuostatus)
			throws DataAccessException {
		    return this.countByHql(FIND_ALL_SHOUSHOU_HQL, new Object[]{userid,shuostatus});
	}


	@Override
	public SaysShuoshuo fingByID(Serializable shouid)
			throws DataAccessException {
		 
		return this.getById(shouid);
	}

}
