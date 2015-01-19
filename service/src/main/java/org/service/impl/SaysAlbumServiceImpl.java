package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysCommentsDao;
import org.dao.ISaysPhotoDao;
import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.service.AbstractBaseService;
import org.service.ISaysAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.Page;

@Service
public class SaysAlbumServiceImpl extends AbstractBaseService implements ISaysAlbumService{
    @Autowired
	private ISaysAlbumDao albumDao;
    
    @Autowired
    private ISaysPhotoDao phptoDao;
    
    private ISaysCommentsDao commDao;
 
	@Override
	public Serializable addAlbum(SaysAlbum al) {
		 return albumDao.addAlbum(al);
	}
	@Override
	public void updateAlbum(SaysAlbum al) {
		albumDao.updateAlbum(al);
		
	}
	@Override
	public int countByUserid(Serializable userid) {
		 
		return albumDao.countByUserid(userid, 0);
	}
	@Override
	public Page<SaysAlbum> findByUserId(SaysAlbum al, Page<SaysAlbum> page) {
         page.setDataSum(albumDao.countByUserid(al.getUserid().getUserid(), 0));
		 List<SaysAlbum> list = albumDao.findByUserId(al.getUserid().getUserid(), page.getFirstResult(),page.getMaxResults(),0);
        page.setResult(list);
        
        System.out.println("list"+list.size());
        
		System.out.println("DataSum"+page.getDataSum());
		System.out.println("PageSum"+page.getPageSum());
		return page;
	 }
	
	
	@Override
	public SaysAlbum findAlbumByalbumid(Serializable albumid) {
		// TODO Auto-generated method stub
		return albumDao.findAlbumByalbumid(albumid);
	}
 
 
	
	
	@Override
	public void delectAlbum(Serializable albumid,String userid) {
    System.out.println("hyp"+userid);
	List<SaysPhoto> list=phptoDao.getPhotoByAlbumId(albumid, "0");
    System.out.println(list.size());
	if(list!=null)
	{
	     SaysAlbum als=	albumDao.getAlbumByuserid(userid);
	     SaysAlbum al=new SaysAlbum();
		al.setAlbumid(als.getAlbumid());
		for(SaysPhoto ph1:list){
		 ph1.setAlbumid(al);
		 phptoDao.update(ph1);
			}
		SaysAlbum al1=albumDao.findAlbumByalbumid(albumid);
		al1.setAlbumstatus(0);
		System.out.println("修改状态");
		  albumDao.update(al1);
	} 
		
	}

 
 

}
