package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRizhitypeDao;
import org.entity.SaysRizhitype;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
@Repository
public class SaysRizhitypeDaoImpl extends AbstractBaseDao<SaysRizhitype>
		implements ISaysRizhitypeDao {
	private static final String FINDBYUSERID_HQL="select rzt from SaysRizhitype rzt where rzt.userid.userid=? and rzt.typestatus!=?";
	private static final String FINDBYUSERIDBYNAME_HQL="select rzt from SaysRizhitype rzt where rzt.userid.userid=? and rzt.typename=?";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysRizhitype> find(Serializable userid,Serializable typestatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		//System.out.println(this.findByHql(FINDBYUSERID_HQL,userid,typestatus).size()+"条数");
		return this.findByHql(FINDBYUSERID_HQL,userid,typestatus);
	}



	@SuppressWarnings("unchecked")
	@Override
	public SaysRizhitype fandBytype(Serializable typeid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		SaysRizhitype zrt = this.getById(typeid);
		return zrt;
	}

	@Override
	public int countByUserid(Serializable userid,Serializable typestatus) throws DataAccessException {
		// TODO Auto-generated method stub
		int a=this.countByHql(FINDBYUSERID_HQL,userid,typestatus);
		System.out.println(a);
		return a;
	}

	@Override
	public List<SaysRizhitype> fandBytypename(Serializable userid, Serializable typename)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return  this.findByHql(FINDBYUSERIDBYNAME_HQL,userid,typename);
	}

}
