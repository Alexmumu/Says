package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysProtectionDao;
import org.entity.SaysProtection;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysProtectionDaoImpl extends AbstractBaseDao<SaysProtection> implements
		ISaysProtectionDao{

	private static final String FINDBYID_HQL="select p from SaysProtection p where p.userid.userid=?";

	@SuppressWarnings("unchecked")
	@Override
	public List<SaysProtection> findSaysProtectionbyuserid(String userid)
			throws DataAccessException {
		return this.findByHql(FINDBYID_HQL, userid);
	}

	@Override
	public Serializable addSaysProtection(SaysProtection saysprotection)
			throws DataAccessException {
		return this.save(saysprotection);
	}

	@Override
	public boolean updateSaysProtection(SaysProtection saysprotection)
			throws DataAccessException {
		this.update(saysprotection);
		return true;
		
	}
	
	
	
	
	
	
	
	
	
	

}
