package org.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import org.dao.ISaysBrowseDao;
import org.dao.ISaysCommentsDao;
import org.dao.ISaysLikeDao;







import org.dao.ISaysNewsDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysShouShousDao;
import org.dao.ISaysUserDao;
import org.entity.SaysNews;
import org.entity.SaysRelay;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.AbstractBaseService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.Page;

@Service
public class SaysShouShouServiceImpl extends AbstractBaseService implements IsaysShouShouService {
 
	@Autowired
	private ISaysShouShousDao shoushouDao;
	@Autowired
	private ISaysNewsDao newsDao;
	@Autowired
	private ISaysCommentsDao commDao;
	@Autowired
	private ISaysBrowseDao browseDao;
	@Autowired
	private ISaysRelayDao relayDao;
	@Autowired
	private ISaysLikeDao likeDao;
	@Autowired
	private ISaysUserDao userDao;
  

	@Override
	public void updateShouShou(SaysShuoshuo ss) {
		shoushouDao.updateShouShou(ss);
		
	}
	@Override
	public int countShouShouByUserId(Serializable userid, int shuostatus) {
		// TODO Auto-generated method stub
		return shoushouDao.countShouShouByUserId(userid, shuostatus);
	}

	@Override
	public Serializable addShouShou(SaysShuoshuo ss) {
		// TODO Auto-generated method stub
		Serializable ssid = this.shoushouDao.addShouShou(ss);
		SaysNews news = new SaysNews();
		news.setUserid(ss.getUserid());
		news.setNewsstatus(1);
		news.setNewscontent((String)ssid);
		this.newsDao.AddNew(news);
		return ssid;
	}
	
	@Override
	public Page<ContentData<Object>> findAllShuoShuo(Serializable userid,
			Page<SaysShuoshuo> page, int shuostatus) {
		Page<ContentData<Object>> conrtentpage = new Page<ContentData<Object>>();
		conrtentpage.setDataSum(shoushouDao.countShouShouByUserId(userid, shuostatus));
		List<SaysShuoshuo> list = shoushouDao.findAllShuoShuo(userid,page.getFirstResult(),page.getMaxResults(), shuostatus);
		List<ContentData<Object>> content= new ArrayList<ContentData<Object>>();
		for(SaysShuoshuo shuoshuo:list){
				ContentData<Object> con = new ContentData<Object>();
				String id = shuoshuo.getShuoid();
				shoushouDao.initialize(shuoshuo.getUserid());
				con.setPinglunnum(commDao.CountComments(id,"1"));
				con.setZhuanfanum(relayDao.countByRelayfromSaysRelay(id));
				con.setYuedunum(browseDao.countByBrowseforSaysBrowse(id));
				con.setDianzannum(likeDao.countByLikeforSaysLike(id));
				con.setData(shuoshuo);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = ((SaysShuoshuo)con.getData()).getShuodate();
				con.setDatadate(sdf.format(date));
				if(shuoshuo.getShuonature() == 1){
					SaysRelay relay = relayDao.findByUseridAndRelayafterSaysRelay(((SaysShuoshuo)con.getData()).getUserid().getUserid(), ((SaysShuoshuo)con.getData()).getShuoid());
					con.setRalaycontent(relay.getRelayfor());
					SaysUser fromuser = userDao.getById(relay.getUseridare().getUserid());
					con.setFromid(fromuser.getUserid());
					con.setFromname(fromuser.getUsername());
				}
				content.add(con);
		}		
		conrtentpage.setResult(content);
		System.out.println(list.size());
		System.out.println(content.size());
		System.out.println(conrtentpage.getDataSum());
		
	
		return conrtentpage;
	}
	public boolean deleteShuoShuo(Serializable shuoid){
		try {
			SaysShuoshuo shuoshuo = shoushouDao.getById(shuoid);
			shuoshuo.setShuostatus(0);
			shoushouDao.update(shuoshuo);
			SaysNews news = this.newsDao.getNewsIDBynewscontent(shuoid);
			this.newsDao.delete(news);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
