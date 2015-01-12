package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysNewsDao;
import org.entity.SaysNews;
import org.service.ISaysNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysNewsServiceImpl implements ISaysNewsService {

	@Autowired
	private ISaysNewsDao newsDao;
	
	public Serializable AddNews(SaysNews news) {
		Serializable i = null;
		if(newsDao.HasNew(news.getNewsid())){
			i = newsDao.AddNew(news);
		}
		return i;
	}

	public boolean DeleteNews(Serializable newsid) {
		try {
			newsDao.deleteById(newsid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<SaysNews> FindNewsByUser(Serializable userid,
			Page<SaysNews> page) {
		page.setDataSum(newsDao.CountNews(userid));
		List<SaysNews> list = newsDao.FindNewsByUser(userid, page
				.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
	}

}
