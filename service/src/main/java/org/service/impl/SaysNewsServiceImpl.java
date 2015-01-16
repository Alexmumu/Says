package org.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.dao.ISaysUserDao;
import org.entity.SaysAlbum;
import org.entity.SaysFriends;
import org.entity.SaysNews;
import org.entity.SaysPhoto;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
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
	@Autowired
	private ISaysUserDao userDao;

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
		List<SaysNews> list = newsDao.FindNewsByUser(userid, page.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		System.out.println(page.getDataSum());
		for(SaysFriends fd:listFriend){
			
			String id = fd.getUserfriendid().getUserid();
			List<SaysNews> listF2 = newsDao.FindNewsByUser(id, page.getFirstResult(), page.getMaxResults());
			for(SaysNews news:listF2){
				list.add(news);
			}
		}
		
		Collections.sort(list);
		System.out.println("list之前");
		for(SaysNews sn:list){
			System.out.println(sn.getNewtime());
		}
		
		List<ContentData<Object>> content= new ArrayList<ContentData<Object>>();
		for(SaysNews news:list){
			if(news.getNewsstatus() == 1 || news.getNewsstatus() == 2)
			{
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				
				con.setPinglunnum(commDao.CountComments(id,"1"));

				con.setZhuanfanum(relayDao.countByRelayfromSaysRelay(id));
				con.setYuedunum(browseDao.countByBrowseforSaysBrowse(id));
				con.setDianzannum(likeDao.countByLikeforSaysLike(id));
				SaysShuoshuo shuoshuo=  shouShousDao.getById(id);
				System.out.println(shuoshuo);
				SaysUser user=new SaysUser();
				user.setUserid(shuoshuo.getUserid().getUserid());
				user.setUsername(shuoshuo.getUserid().getUsername());
				user.setUserimg(shuoshuo.getUserid().getUserimg());
				shuoshuo.setUserid(user);
				con.setData(shuoshuo);
				con.setDatadate(((SaysShuoshuo)con.getData()).getShuodate());
				content.add(con);
			}
			if(news.getNewsstatus() == 3 || news.getNewsstatus() == 4){
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				System.out.println("日志ID"+id);
				con.setPinglunnum(commDao.CountComments(id, "1"));
				con.setZhuanfanum(relayDao.countByRelayfromSaysRelay(id));
				con.setYuedunum(browseDao.countByBrowseforSaysBrowse(id));
				con.setDianzannum(likeDao.countByLikeforSaysLike(id));
				SaysRizhi rizhi=rizhiDao.getById(id);
				SaysRizhitype rizhitype = new SaysRizhitype();
				rizhitype.setTypeid(rizhi.getRizhitype().getTypeid());
				rizhitype.setTypename(rizhi.getRizhitype().getTypename());
				rizhitype.setUserid(null);
				rizhi.setRizhitype(rizhitype);
				SaysUser user = new SaysUser();
				user.setUserid(rizhi.getRizhiuserid().getUserid());
				user.setUsername(rizhi.getRizhiuserid().getUsername());
				user.setUserimg(rizhi.getRizhiuserid().getUserimg());
				rizhi.setRizhiuserid(user);
				con.setData(rizhi);
				con.setDatadate(((SaysRizhi)con.getData()).getRizhidate());
				content.add(con);
			}
			if(news.getNewsstatus() == 5 || news.getNewsstatus() == 6){
				ContentData<Object> con = new ContentData<Object>();
				String id = news.getNewscontent();
				con.setPinglunnum(commDao.CountComments(id, "1"));
				con.setZhuanfanum(relayDao.countByRelayfromSaysRelay(id));
				con.setYuedunum(browseDao.countByBrowseforSaysBrowse(id));
				con.setDianzannum(likeDao.countByLikeforSaysLike(id));
				con.setDatadate(((SaysPhoto)con.getData()).getPhotodate());
				SaysPhoto photo = photoDao.getById(id);
				SaysAlbum album = new SaysAlbum();
				album.setAlbumid(photo.getAlbumid().getAlbumid());
				album.setAlbumtitle(photo.getAlbumid().getAlbumtitle());
				album.setUserid(null);
				photo.setAlbumid(album);
				SaysUser user = new SaysUser();
				user.setUserid(photo.getUserid().getUserid());
				user.setUsername(photo.getUserid().getUsername());
				user.setUserimg(photo.getUserid().getUserimg());
				photo.setUserid(user);
				con.setData(photo);
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
