package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysPhotoDao;
import org.entity.SaysPhoto;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SyasPhotoDaoImpl extends AbstractBaseDao<SaysPhoto> implements ISaysPhotoDao{
	private static final String FINDPHOTOBYALBUMID_HQL="from SaysPhoto ph where ph.albumid.albumid=?";

	@SuppressWarnings("unchecked")
	public List<SaysPhoto> findPhotoByAlbumId(Serializable albumid,
			int firstResult, int maxResults) throws DataAccessException {
		 
		return this.findByHql(FINDPHOTOBYALBUMID_HQL, firstResult, maxResults,new Object[]{albumid});
	}

	public Serializable addPhotoIntoAlbum(SaysPhoto ph)
			throws DataAccessException {
		 
		return this.save(ph);
	}

	public void updatePhoto(SaysPhoto ph) throws DataAccessException {
		this.update(ph);
		
	}

	public void deletPhoto(Serializable photoid) throws DataAccessException {
		this.deleteById(photoid);
		
	}

 

}
