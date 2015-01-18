package org.service;

import java.io.Serializable;



import org.entity.SaysNews;
import org.vo.ContentData;
import org.vo.Page;

public interface ISaysNewsService {
	/**
	 * 返回动态的Page对象
	 * @param userid 用户ID
	 * @param page Page对象
	 * @return
	 */
	public Page<ContentData<Object>> findNewsByUser(Serializable userid,Page<SaysNews> page);
	
	public Serializable addNews(SaysNews news);
	
	public boolean deleteNews(Serializable newsid);
	
	/**
	 * 记录用户好友的动态总条数
	 * @param userid 用户ID
	 * @return
	 */
	public int countFriends(Serializable userid);
	/**
	 * 记录传入的用户的总动态数
	 * @param userid
	 * @return
	 */
	public int countByMy(Serializable userid);
	
}
