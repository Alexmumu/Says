package org.service;

import java.io.Serializable;

import org.entity.SaysNews;
import org.vo.Page;

public interface ISaysNewsService {

	public Page<SaysNews> FindNewsByUser(Serializable userid,Page<SaysNews> page);
	
	public Serializable AddNews(SaysNews news);
	
	public boolean DeleteNews(Serializable newsid);
	
}
