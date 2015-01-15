package org.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dao.ISaysBrowseDao;
import org.dao.ISaysCommentsDao;
import org.dao.ISaysFriendsDao;
import org.dao.ISaysLikeDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysFriends;
import org.entity.SaysNews;
import org.entity.SaysPhoto;
import org.entity.SaysRizhi;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.Page;

@Service
public class SaysNewsServiceImpl implements ISaysNewsService {

	@Autowired
	private ISaysNewsDao newsDao;
	@Autowired
	private ISaysShouShousDao shouShousDao;
	@Autowired
	private ISaysFriendsDao friendsDao;
	@Autowired
	private ISaysRizhiDao rizhiDao;
	@Autowired
	private ISaysPhotoDao photoDao;
	@Autowired
	private ISaysCommentsDao commDao;
	@Autowired
	private ISaysRelayDao relayDao;
	@Autowired
	private ISaysBrowseDao browseDao;
	@Autowired
	private ISaysLikeDao likeDao;
	

	@Override
	public int countFriends(Serializable userid) {
		List<SaysFriends> list = friendsDao.findbyuseridallSaysFriends(userid, 0,Integer.MAX_VALUE);
		int count = newsDao.CountNews(userid);
		for(SaysFriends fd:list){
		
			String id = fd.getUserfriendid().getUserid();
			count +=  newsDao.CountNews(id);
			System.out.println(id);
		}
		System.out.println("总动态条数:"+count);
		return count;
	}
	
	
	public Serializable addNews(SaysNews news) {
		Serializable i = null;
		if(newsDao.HasNew(news.getNewsid())){
			i = newsDao.AddNew(news);
		}
		return i;
	}

	public boolean deleteNews(Serializable newsid) {
		try {
			newsDao.deleteById(newsid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<ContentData<Object>> findNewsByUser(Serializable userid,
			Page<SaysNews> page) {
		Page<ContentData<Object>> conrtentpage = new Page<ContentData<Object>>();
		page.setDataSum(newsDao.CountNews(userid));
		
		List<SaysFriends> listFriend = friendsDao.findbyuseridallSaysFriends(userid, 0,Integer.MAX_VALUE);
		List<SaysNews> list = newsDao.FindNewsByUser(userid, page
				.getFirstResult(), page.getMaxResults());
		for(SaysFriends fd:listFriend){
			
			String id = fd.getUserfriendid().getUserid();
			List<SaysNews> listF2 = newsDao.FindNewsByUser(id, page
				.getFirstResult(), page.getMaxResults());
			for(SaysNews news:listF2){
				list.add(news);
			}
		}
		
		List<ContentData<Object>> content= new ArrayList<ContentData<Object>>();
		for(SaysNews news:list){
			if(news.getNewsstatus() == 1 || news.getNewsstatus() == 2)
			{
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				con.setData(shouShousDao.loadByID(id));
				con.setPinglunnum(commDao.CountComments(id,"1"));
				//con.setZhuanfanum(relayDao.countByUseridSaysRelay(userid));
				//con.setYuedunum(browseDao.countByUseridSaysBrowse(userid));
				//con.setDianzannum(likeDao.countByUseridSaysLike(userid));
				con.setDatadate(((SaysShuoshuo)con.getData()).getShuodate());
				SaysShuoshuo shuoshuo=(SaysShuoshuo)con.getData();
				shouShousDao.initialize(shuoshuo.getUserid());
				content.add(con);
			}
			if(news.getNewsstatus() == 3 || news.getNewsstatus() == 4){
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				con.setData(rizhiDao.loadByID(id));
				con.setPinglunnum(commDao.CountComments(id, "1"));
				con.setDatadate(((SaysRizhi)con.getData()).getRizhidate());
				SaysRizhi sr=(SaysRizhi) con.getData();
				rizhiDao.initialize(sr.getRizhitype());
				sr.getRizhitype().setUserid(null);
				rizhiDao.initialize(sr.getRizhiuserid());
				content.add(con);
			}
			if(news.getNewsstatus() == 5 || news.getNewsstatus() == 6){
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				con.setData(photoDao.loadByID(id));
				con.setPinglunnum(commDao.CountComments(id, "1"));
				con.setDatadate(((SaysPhoto)con.getData()).getPhotodate());
				SaysPhoto sp=(SaysPhoto) con.getData();
				photoDao.initialize(sp.getAlbumid());
				sp.getAlbumid().setUserid(null);
				photoDao.initialize(sp.getUserid());
				content.add(con);
			}
		}
		conrtentpage.setDataSum(this.countFriends(userid));
		conrtentpage.setResult(content);
		System.out.println(content.size());
		System.out.println(conrtentpage.getDataSum());
		return conrtentpage;
	}


}
