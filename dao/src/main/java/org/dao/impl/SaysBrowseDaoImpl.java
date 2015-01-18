package org.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.dao.ISaysBrowseDao;
import org.entity.SaysBrowse;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


/**
 * 2015/1/9
 * @author Eyser
 * 浏览阅读表的SaysBrowseDaoImpl实现类继承AbstractBaseDao类的方法
 * 并实现ISaysBrowseDao接口
 */
@Repository
public class SaysBrowseDaoImpl extends AbstractBaseDao<SaysBrowse> implements
ISaysBrowseDao {
	private static final String FINDBYUSERID_HQL="select sb from SaysBrowse sb where sb.useridare.userid=?";
	private static final String FINDBYBrowsefor_HQL="select sb from SaysBrowse sb where sb.browsefor=?";
	private static final String FINDBYUSERIDByUser_HQL="select sb from SaysBrowse sb where sb.browsefor=? and sb.useridare.userid=? order by sb.browsetime desc";
	private static final String FINDBYUSERIDByUser_HQLA="select  sb from SaysBrowse sb where sb.browsefor=? and sb.useridare.userid=? order by sb.browsetime desc";
	@Override
	public void saveSaysBrowse(SaysBrowse sb) throws DataAccessException {
		this.save(sb);	
	}

	@Override
	public void deleteSaysBrowse(Serializable browseid)
			throws DataAccessException {
			this.deleteById(browseid);	
	}

	@Override
	public int countByUseridSaysBrowse(Serializable userid)
			throws DataAccessException {
		this.countByHql(FINDBYUSERID_HQL,new Object[]{userid});
		return 0;
	}


	@Override
	public List<SaysBrowse> findSaysBrowseByitem(Serializable browsefor,Serializable useridare) {
		@SuppressWarnings("unchecked")
		List<SaysBrowse> list=this.findByHql(FINDBYUSERIDByUser_HQL,new Object[]{browsefor,useridare});
		return list;
	}

	@Override
	public void updateSaysBrowse(SaysBrowse sb) throws DataAccessException {
		this.update(sb);
		
	}

	@Override
	public List<SaysBrowse> findSaysBrowse(int firstResult, int maxResults,
			Serializable browsefor, Serializable useridare)
			throws DataAccessException {
		@SuppressWarnings("unchecked")
		List<SaysBrowse> list=this.findByHql(FINDBYUSERIDByUser_HQLA, firstResult, maxResults, new Object[]{browsefor,useridare});
		return list;
	}

	@Override
	public int countByBrowseforSaysBrowse(Serializable browsefor)
			throws DataAccessException {
		return this.countByHql(FINDBYBrowsefor_HQL,new Object[]{browsefor});
	}

	

	

	
	

}
