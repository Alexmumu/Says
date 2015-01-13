package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysPhotoDao;
import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.service.AbstractBaseService;
import org.service.ISaysPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysPhotoServiceImpl extends AbstractBaseService implements ISaysPhotoService{
     @Autowired
	private ISaysPhotoDao photoDao;
 

	@Override
	public Serializable addPhotoIntoAlbum(SaysPhoto ph) {
		 
		return photoDao.addPhotoIntoAlbum(ph);
	}

	@Override
	public void updatePhoto(SaysPhoto ph) {
		photoDao.updatePhoto(ph);
		
	}
	
	
	@Override
	public int countPhotoByAlbum(Serializable albumid, String photostatus) {
		 
		return photoDao.countPhotoByAlbum(albumid, photostatus);
	}

	@Override
	public Page<SaysPhoto> findPhotoByAlbumId(SaysPhoto ph,
		Page<SaysPhoto> page, String photostatus) {
		page.setDataSum(photoDao.countPhotoByAlbum(ph.getAlbumid().getAlbumid(), photostatus));
		List<SaysPhoto> list = photoDao.findPhotoByAlbumId(ph.getAlbumid().getAlbumid(), page.getFirstResult(),page.getMaxResults(), photostatus);
        page.setResult(list);
		System.out.println(page.getDataSum());
		System.out.println(page.getPageSum());
		return page;
	}



}
