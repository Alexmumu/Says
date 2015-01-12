package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRizhiDao;
import org.entity.SaysRizhi;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public  class SaysRizhiDaoImpl extends AbstractBaseDao<SaysRizhi> implements ISaysRizhiDao{

	
	private static final String FINDBYUSERID_HQL="select rz from SaysRizhi rz where rz.rizhiuserid.userid=? and rz.rizhistatus!=? order by rz.rizhicontent desc";
	private static final String DELETERIZHITYPE_HQL="update SaysRizhi rz set rz.rizhistatus=? where rz.rizhiuserid.userid=? and rz.rizhiid=?";
	private static final String FINDBRIZHITYPE_HQL="select rz from SaysRizhi rz where rz.rizhiuserid.userid=? and rz.rizhitype.typeid=? and rz.rizhistatus!=? order by rz.rizhicontent desc";
	
	public Serializable addSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException {
		 
		return this.save(saysrizhi);
		
	}

	@SuppressWarnings("unchecked")
	public SaysRizhi SaysRizhiById(Serializable rizhiid) throws DataAccessException {
		SaysRizhi  rz = this.getById(rizhiid);
		//System.out.println(rz.getRizhititle()+" "+rz.getRizhicontent());
		// TODO Auto-generated method stub
		return rz;
		
	}

	public void updateSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException {
		// TODO Auto-generated method stub
		this.update(saysrizhi);
	}

	@SuppressWarnings("unchecked")
	public List<SaysRizhi> fandSaysRizhi(Serializable userid,int rizhistatus,int firstResult,
			int maxResults) throws DataAccessException {
		// TODO Auto-generated method stub
		//System.out.println(findByHql(FINDBYUSERID_HQL, firstResult, maxResults, new Object[]{userid,rizhistatus}).size());
		return this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults, new Object[]{userid,rizhistatus});
	}

	@Override
	public int countByUserid(Serializable userid,int rizhistatus) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.countByHql(FINDBYUSERID_HQL, new Object[]{userid,rizhistatus});
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysRizhi> findRizhitype(Serializable userid,Serializable rizhitype,int rizhistatus,int firstResult,int maxResults) throws DataAccessException {
		// TODO Auto-generated method stub
		//System.out.println(this.findByHql(FINDBRIZHITYPE_HQL, firstResult, maxResults, new Object[]{userid,rizhitype,rizhistatus}).size());
		return  this.findByHql(FINDBRIZHITYPE_HQL, firstResult, maxResults, new Object[]{userid,rizhitype,rizhistatus});
	}

	@Override
	public void updateRizhitype(Serializable userid, Serializable rizhitype,Serializable rizhistatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.findByHql(DELETERIZHITYPE_HQL, userid,rizhitype,rizhistatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaysRizhi> findRizhitypes(Serializable userid,
			Serializable rizhitype, int rizhistatus) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.findByHql(FINDBRIZHITYPE_HQL, userid,rizhitype,rizhistatus);
	}

}