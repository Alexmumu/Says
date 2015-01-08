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
	private static final String FINDBYUSERID_HQL="select * from SaysAlbum al where al.userid.userid=?";
	@SuppressWarnings("unchecked")
	
	public List<SaysAlbum> findByUserId(Serializable userid, int firstResult,
			int maxResults) throws DataAccessException {
		return this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults, new Object[]{userid});
	}
	
	public int countByUserid(Serializable userid) throws DataAccessException {
		return this.countByHql(FINDBYUSERID_HQL, new Object[]{userid});
	}
	

	

}
