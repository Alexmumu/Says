package org.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.dao.ISaysLeavewordDao;
import org.entity.SaysLeaveword;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 2015/1/9
 * @author Eyser
 * 留言表的SaysLeavewordDaoImpl实现类继承AbstractBaseDao类的方法
 * 并实现ISaysLeavewordDao接口
 */
@Repository
public class SaysLeavewordDaoImpl extends AbstractBaseDao<SaysLeaveword> implements
ISaysLeavewordDao{
	private static final String FINDBYUSERID_HQL="select lw from SaysLeaveword lw where lw.userid.userid=? and lw.levewodidstatus=? order by lw.leaveworddate desc";
	private static final String FINDBYUSERIDC_HQL="select count(lw) from SaysLeaveword lw where lw.userid.userid=? and lw.levewodidstatus=?";
	private static final String FINDByLeavewordid_HQL="select lw from SaysLeaveword lw where lw.leavewordid=?";
	
	@Override
	public List<SaysLeaveword> findSaysLeavewords(
			int firstResult, int maxResults,
			 Serializable userid, Serializable levewodidstatus) throws DataAccessException {
		 	@SuppressWarnings("unchecked")
			List<SaysLeaveword> list=this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults,  new Object[]{userid,levewodidstatus});
		 	return list;
	}
	@Override
	public int countAllSaysLeaveword(Serializable userid,Serializable levewodidstatus) throws DataAccessException {	
		return this.countByHql(FINDBYUSERIDC_HQL, new Object[]{userid,levewodidstatus});
	}
	@Override
	public void saveSaysLeaveword(SaysLeaveword lw) throws DataAccessException {
		this.save(lw);
	}
	@Override
	public void deleteSaysLeaveword(Serializable  leavewordid) throws DataAccessException {
		this.deleteById(leavewordid);	
	}
	@Override
	public SaysLeaveword findByLeavewordidSaysLeaveword(Serializable leavewordid)
			throws DataAccessException {
		return (SaysLeaveword) this.findByHql(FINDByLeavewordid_HQL, new Object[]{leavewordid}).get(0);
		
	}
	
	


}
