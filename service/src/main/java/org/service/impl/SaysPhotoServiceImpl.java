package org.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysUserDao;
import org.entity.SaysAlbum;
import org.entity.SaysNews;
import org.entity.SaysPhoto;
import org.entity.SaysRelay;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.AbstractBaseService;
import org.service.ISaysLikeService;
import org.service.ISaysNewsService;
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
    private ISaysLikeService likeDao;
     
     @Autowired
    private ISaysRelayDao relDao;
     
     @Autowired 
     private ISaysNewsDao newDao;
     
     @Autowired
     private ISaysUserDao userdao;
     
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
		List<ContentData<Object>> content= new ArrayList<ContentData<Object>>();
		for(SaysPhoto ph:list)
		{
			ContentData<Object> conn = new ContentData<Object>();
			conn.setData(ph);
			//统计评论
			conn.setPinglunnum(commDao.CountComments(ph.getPhotoid(), "1"));
			//统计转发
			conn.setZhuanfanum(relDao.countByRelayfromSaysRelay(ph.getPhotoid()));
			//统计点赞
			conn.setDianzannum(likeDao.countByLikeforSaysLike(ph.getPhotoid()));
			
			if(ph.getPhototype() == 1){
				
				SaysRelay relay = relDao.findByUseridAndRelayafterSaysRelay(((SaysPhoto)conn.getData()).getUserid().getUserid(), ((SaysPhoto)conn.getData()).getPhotoid());
			//	relDao.initialize(relay.getUseridare());
				conn.setRalaycontent(relay.getRelayfor());
				SaysUser fromuser = userdao.getById(relay.getUseridare().getUserid());
				conn.setFromid(fromuser.getUserid());
				conn.setFromname(fromuser.getUsername());
				System.out.println("----------源ID----------");
				System.out.println(conn.getFromname());
			}
			content.add(conn);
		}
		pagecount.setResult(content);
		return pagecount;
	}

 

	@Override
	public void delect(Serializable photoid) {
		// TODO Auto-generated method stub
		SaysPhoto ph= photoDao.getPhotoid(photoid);
		ph.setPhotostatus("0");
		photoDao.update(ph);
	    SaysNews sw=newDao.getNewsIDBynewscontent(photoid);
	    newDao.delete(sw);
		System.out.println("删除了");
		 
	}



}
