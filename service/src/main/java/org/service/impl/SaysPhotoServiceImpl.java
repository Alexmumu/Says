package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.service.AbstractBaseService;
import org.service.ISaysPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.Page;

@Service
public class SaysPhotoServiceImpl extends AbstractBaseService implements ISaysPhotoService{
     @Autowired
	private ISaysPhotoDao photoDao;
     @Autowired
    private ISaysCommentsDao commDao;
     
     @Autowired
    private ISaysRelayDao relDao;
     
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

 
	public Page<ContentData<Object>> findPhotoByAlbumId(String albumid,Page<SaysPhoto> page) {
		Page<ContentData<Object>> pagecount=new Page<ContentData<Object>>();
        page.setDataSum(photoDao.countPhotoByAlbum(albumid, "0"));
		List<SaysPhoto> list = photoDao.findPhotoByAlbumId(albumid, page.getFirstResult(),page.getMaxResults(), "0");
		for(SaysPhoto ph:list)
		{
			ContentData<Object> conn = new ContentData<Object>();
			conn.setYuedunum(commDao.CountComments(ph.getPhotoid(), "1"));
			conn.setZhuanfanum(relDao);
		}
        
 
		return pagecount;
	}



}
