package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRelayDao;
import org.entity.SaysRelay;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


/**
 * 2015/1/9
 * @author Eyser
 * 转发转载记录表的SaysRelayDaoImpl实现类继承AbstractBaseDao的方法
 * 并实现ISaysRelayDao接口
 */
@Repository
class SaysRelayDaoImpl extends AbstractBaseDao<SaysRelay> implements
ISaysRelayDao {
	private static final String FINDBYUSERID_HQL="select sr from SaysRelay sr where sr.useridare.userid=? order by sr.relaytime desc";
	private static final String FINDBYRelayfrom_HQL="select sr from SaysRelay sr where sr.relayfrom=? order by sr.relaytime desc";
	private static final String FINDBYRelayafter_HQL="select sr from SaysRelay sr where sr.relayafter=? order by sr.relaytime desc";
	private static final String FINDBYUSERIDAndRelayafter_HQL="select sr from SaysRelay sr where sr.useridare.userid=? and sr.relayafter=? order by sr.relaytime desc";
	
	@Override
	public void saveSaysRelay(SaysRelay ar) throws DataAccessException {
		this.save(ar);	
	}
	@Override
	public void deleteSaysRelay(Serializable relayid)
			throws DataAccessException {
		this.deleteById(relayid);	
	}
	@Override
	public int countByUseridSaysRelay(Serializable userid)
			throws DataAccessException {
		return this.countByHql(FINDBYUSERID_HQL, new Object[]{userid});
	}
	@Override
	public List<SaysRelay> findByUseridSaysRelay(Serializable userid)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		List<SaysRelay> list=this.findByHql(FINDBYUSERID_HQL,new Object[]{userid});
		return list;
	}
	@Override
	public int countByRelayfromSaysRelay(Serializable relayfrom)
			throws DataAccessException {
		return this.countByHql(FINDBYRelayfrom_HQL, new Object[]{relayfrom});
		
	}
	@Override
	public int countByRelayafterSaysRelay(Serializable relayafter)
			throws DataAccessException {
		
		return this.countByHql(FINDBYRelayafter_HQL, new Object[]{relayafter});
		
	}
	@Override
	public List<SaysRelay> findByUseridAndRelayafterSaysRelay(
			Serializable userid, Serializable relayafter)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		List<SaysRelay> list= this.findByHql(FINDBYUSERIDAndRelayafter_HQL,userid,relayafter);
		return list;
	}
}
