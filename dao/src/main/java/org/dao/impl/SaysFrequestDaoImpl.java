package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysFrequestDao;
import org.entity.SaysFrequest;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysFrequestDaoImpl extends AbstractBaseDao<SaysFrequest> implements
		ISaysFrequestDao{

	private static final String FIND_HQL="select fq from SaysFrequest fq where fq.fruser.userid=?";
	private static final String FINDBYFRID_HQL="select f from SaysFrequest f where f.frid=?";
	private static final String COUNT_HQL="select count(sf) from SaysFrequest sf where sf.fruser.userid=?";
	private static final String INFO_HQL="select f from SaysFrequest f where  f.fruser.userid=? and f.fruserare.userid=?";

	
	@Override
	public Serializable addSaysFrequest(SaysFrequest saysfrequest)
			throws DataAccessException {
		return this.save(saysfrequest);
	}

	@Override
	public boolean deletedSaysFrequest(String frid)
			throws DataAccessException {
		this.deleteById(frid);
		return true;
	}

	@Override
	public void updateSaysFrequest(SaysFrequest saysfrequest)
			throws DataAccessException {
		this.update(saysfrequest);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaysFrequest> selectSaysFrequest(Serializable fruser,
			int firstResult, int maxResults) throws DataAccessException {
		return this.findByHql(FIND_HQL, firstResult, maxResults, new Object[]{fruser});
	}

	@Override
	public List selectSaysFrequest2(String frid) throws DataAccessException {
		
		return this.findByHql(FINDBYFRID_HQL, frid);
		
	}

	@Override
	public int countSaysFrequest(Serializable fruser)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.countByHql(COUNT_HQL, fruser);
	}

	@Override
	public List selectbyfruerandfruserare(String fruser,
			String fruserare) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.findByHql(INFO_HQL, fruser,fruserare);
	}

	

}
