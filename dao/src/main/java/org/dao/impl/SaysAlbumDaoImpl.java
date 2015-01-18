package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysAlbumDao;
import org.entity.SaysAlbum;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
@Repository
public class SaysAlbumDaoImpl extends AbstractBaseDao<SaysAlbum> implements
		ISaysAlbumDao {
	private static final String FINDBYUSERID_HQL="select al from SaysAlbum al where al.userid.userid=? and albumstatus!=?  order by albumdate desc";
	@SuppressWarnings("unchecked")
	
	public List<SaysAlbum> findByUserId(Serializable userid, int firstResult,
			int maxResults,int albumstatus) throws DataAccessException {
		return this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults, new Object[]{userid,albumstatus});
	}
	
	public int countByUserid(Serializable userid,int albumstatus) throws DataAccessException {
		return this.countByHql(FINDBYUSERID_HQL, new Object[]{userid,albumstatus});
	}
	public Serializable addAlbum(SaysAlbum al) throws DataAccessException {
		return this.save(al);
	}

	public void delectAlbum(Serializable albumid) throws DataAccessException {
		this.deleteById(albumid);
		
	}

	public void updateAlbum(SaysAlbum al) throws DataAccessException {
		 
		 this.update(al);
	}

	@Override
	public SaysAlbum findAlbumByalbumid(Serializable albumid)
			throws DataAccessException {
		 
		return this.getById(albumid);
	}
	

	

}
