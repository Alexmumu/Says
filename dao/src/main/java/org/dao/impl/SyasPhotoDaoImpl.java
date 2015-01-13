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
	private static final String FINDPHOTOBYALBUMID_HQL="select ph from SaysPhoto ph where ph.albumid.albumid=? and ph.photostatus!=? order by photodate desc";
     
	@SuppressWarnings("unchecked")
	public List<SaysPhoto> findPhotoByAlbumId(Serializable albumid,
			int firstResult, int maxResults,String photostatus) throws DataAccessException {
		 
		return this.findByHql(FINDPHOTOBYALBUMID_HQL, firstResult, maxResults,new Object[]{albumid,photostatus});
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

	@Override
	public int countPhotoByAlbum(Serializable albumid, String photostatus)
			throws DataAccessException {
		return this.countByHql(FINDPHOTOBYALBUMID_HQL, new Object[]{albumid,photostatus});
		 
	}

 
	 
	@SuppressWarnings("unchecked")
	public List<SaysPhoto> getPhotoByAlbumId(Serializable albumid,
			String photostatus) throws DataAccessException {
		 
		return this.findByHql(FINDPHOTOBYALBUMID_HQL,new Object[]{albumid,photostatus});
	}

	@Override
	public SaysPhoto getPhotoByphotoid(Serializable photoid)
			throws DataAccessException {
		 
		return this.getById(photoid);
	}
 

 

 

}
