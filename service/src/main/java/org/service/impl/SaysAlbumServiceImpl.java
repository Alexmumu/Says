package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysPhotoDao;
import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.service.AbstractBaseService;
import org.service.ISaysAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysAlbumServiceImpl extends AbstractBaseService implements ISaysAlbumService{
    @Autowired
	private ISaysAlbumDao albumDao;
    
    @Autowired
    private ISaysPhotoDao phptoDao;
 
	@Override
	public Serializable addAlbum(SaysAlbum al) {
		 return albumDao.addAlbum(al);
	}
	@Override
	public void updateAlbum(SaysAlbum al) {
		albumDao.updateAlbum(al);
		
	}
	@Override
	public int countByUserid(Serializable userid, int albumstatus) {
		 
		return albumDao.countByUserid(userid, albumstatus);
	}
	@Override
	public Page<SaysAlbum> findByUserId(SaysAlbum al, Page<SaysAlbum> page,int albumstatus) {
		page.setDataSum(albumDao.countByUserid(al.getUserid().getUserid(), 1));
		 List<SaysAlbum> list = albumDao.findByUserId(al.getUserid().getUserid(), page.getFirstResult(), page.getMaxResults(),1);
        page.setResult(list);
		System.out.println(page.getDataSum());
		System.out.println(page.getPageSum());
		return page;
	 }
	
	
	@Override
	public SaysAlbum findAlbumByalbumid(Serializable albumid) {
		// TODO Auto-generated method stub
		return albumDao.findAlbumByalbumid(albumid);
	}
 
 
	
	
	@Override
	public void delectAlbum(Serializable albumid,String Ralbumid) {
 System.out.println(albumid);
	List<SaysPhoto> list=phptoDao.getPhotoByAlbumId(albumid, "0");
	SaysAlbum al=albumDao.findAlbumByalbumid(Ralbumid);
	al.setAlbumid(Ralbumid);
	System.out.println(list.size());
	if(list!=null)
	{
		for(SaysPhoto ph1:list){
		 ph1.setAlbumid(al);
		 phptoDao.update(ph1);
			}
	   albumDao.delectAlbum(albumid);
	} 
		
	}

 
	 

}
