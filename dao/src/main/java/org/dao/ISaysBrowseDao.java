package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysBrowse;
import org.entity.SaysLeaveword;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;


/**
 * 2015/1/8
 * @author Eyser
 * 浏览阅读表的ISaysBrowseDao接口继承IBaseDao基本方法
 */
public interface ISaysBrowseDao extends IBaseDao<SaysBrowse>{
	/**
	 * 添加浏览阅读信息
	 * @throws DataAccessException
	 */
	 public void saveSaysBrowse(SaysBrowse sb)throws DataAccessException;
	 /**
	 * 删除浏览阅读信息
	 * @throws DataAccessException
	 */
	 public void deleteSaysBrowse(Serializable browseid)throws DataAccessException;
	 /**
	  * 查询浏览阅读表的数量
	  * @param userid
	  * @return
	  * @throws DataAccessException
	  */
	 public int countByUseridSaysBrowse(Serializable userid)throws DataAccessException;
	 public int countByBrowseforSaysBrowse(Serializable browsefor)throws DataAccessException;
	 
	 /**
	 * 根据项目查看访问用户信息
	 * @throws DataAccessException
	 */
	public List<SaysBrowse> findSaysBrowseByitem(Serializable browsefor,Serializable useridare);
	
	public void updateSaysBrowse(SaysBrowse sb) throws DataAccessException;
	
	public List<SaysBrowse> findSaysBrowse(int firstResult,int maxResults, Serializable browsefor,Serializable useridare)
			throws DataAccessException;
	
	
	
}
