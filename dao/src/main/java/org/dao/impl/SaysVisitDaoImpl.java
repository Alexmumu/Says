package org.dao.impl;

import java.io.Serializable;

import java.util.List;

import org.dao.ISaysVisitDao;
import org.entity.SaysVisit;
import org.hibernateUtil.AbstractBaseDao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysVisitDaoImpl extends AbstractBaseDao<SaysVisit> implements
		ISaysVisitDao {

	private static final String FINDBYUSERID_HQL="select sv from SaysVisit sv where sv.userid.userid=? order by sv.visittime desc";
	private static final String FINDMYBYUSERID_HQL="select sv from SaysVisit sv where sv.fromuserid.userid=? order by sv.visittime desc";
	private static final String FINDBYUSERID_FROMUSERID_HQL="select sv from SaysVisit sv where sv.userid.userid=? and sv.fromuserid.userid=? order by sv.visittime desc";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysVisit> findSaysVisit(Serializable userid, int firstResult,
			int maxResults) throws DataAccessException {
		// TODO Auto-generated method stub
		
		
		return this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults,new Object[]{userid});
	}
	@Override
	public int countByUserid(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return  this.countByHql(FINDBYUSERID_HQL, new Object[]{userid});
	}
	
	
	@Override
	public List<SaysVisit> findMySaysVisit(Serializable fromuserid,
			int firstResult, int maxResults) throws DataAccessException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<SaysVisit> list = this.findByHql(FINDMYBYUSERID_HQL, firstResult, maxResults,new Object[]{fromuserid});
		return list;
	}
	@Override
	public int countMyByUserid(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return  this.countByHql(FINDMYBYUSERID_HQL, new Object[]{userid});
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysVisit> findByVisitId(Serializable userid,Serializable fromuserid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		List<SaysVisit> list = this.findByHql(FINDBYUSERID_FROMUSERID_HQL,userid,fromuserid);
		return list;
	}




	


}
