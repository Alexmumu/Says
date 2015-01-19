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
    private static final String DELECT_PHOTO_HQL="update SaysPhoto ph set ph.photostatus=0 where ph.photoid=?" ;
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

	@Override
	public void delect(Serializable photoid) throws DataAccessException {
		 System.out.println("ok1");
		this.findByHql(DELECT_PHOTO_HQL,photoid);
		System.out.println("ok2");
	}

	@Override
	public SaysPhoto getPhotoid(Serializable photoid)
			throws DataAccessException {
		 
		return this.getById(photoid);
	}
 

 

 

}
