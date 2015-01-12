package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysUserwordDao;
import org.entity.SaysUserword;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Eyser
 * 留言主人寄语表的SaysUserwordDaoImpl实现类继承AbstractBaseDao的方法
 * 并实现ISaysUserwordDao接口
 */
@Repository
public class SaysUserwordDaoImpl extends AbstractBaseDao<SaysUserword> implements
ISaysUserwordDao{
	private static final String FINDBYUSERID_HQL="select uw from SaysUserword uw where uw.userid.userid=?";
	
	@Override
	public void saveSaysUserword(SaysUserword suw)
			throws DataAccessException {
		this.save(suw);	
	}
	@Override
	public void updateSaysUserword(SaysUserword saysUserword)
			throws DataAccessException {
		this.update(saysUserword);	
	}
	@Override
	public SaysUserword findSaysUserwordByUserId(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		SaysUserword suw=(SaysUserword) this.findByHql(FINDBYUSERID_HQL,new Object[]{userid}).get(0);	
		return suw;
	}
	@Override
	public int findSaysUserwordByUserId1(Serializable userid)
			throws DataAccessException {
		return this.countByHql(FINDBYUSERID_HQL,new Object[]{userid});
		
	}	
}
