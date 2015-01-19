package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysNewsDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysAlbum;
import org.entity.SaysNews;
import org.entity.SaysShuoshuo;
import org.service.AbstractBaseService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysShouShouServiceImpl extends AbstractBaseService implements IsaysShouShouService {
 
	@Autowired
	private ISaysShouShousDao shoushouDao;
    @Autowired
	private ISaysNewsDao newsDao;
 
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
	
	@Override
	public Page<SaysShuoshuo> findAllShuoShuo(SaysShuoshuo ss,
			Page<SaysShuoshuo> page, int shuostatus) {
		page.setDataSum(shoushouDao.countShouShouByUserId(ss.getUserid().getUserid(), 1));
		 List<SaysShuoshuo> list = shoushouDao.findAllShuoShuo(ss.getUserid().getUserid(), page.getFirstResult(), page.getMaxResults(),shuostatus);
       page.setResult(list);
		System.out.println(page.getDataSum());
		System.out.println(page.getPageSum());
		return page;
	}

}
