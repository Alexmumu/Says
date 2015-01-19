package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysNews;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysNewsDao extends IBaseDao<SaysNews> {

	/**
	 * 根据用户ID查询该用户所有相关动态
	 * @param userid 用户ID
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysNews> FindNewsByUser(Serializable userid, int firstResult,
			int maxResults)throws DataAccessException ;
	
	/**
	 * 查询当前动态数量
	 * @param userid 用户ID
	 * @return
	 * @throws DataAccessException
	 */
	public int CountNews(Serializable userid)throws DataAccessException;
	
	
	/**
	 * 为用户添加一条动态
	 * @param news SaysNews对象
	 * @throws DataAccessException
	 */
	public Serializable AddNew(SaysNews news)throws DataAccessException;
	
	/**
	 * 判断当前动态是否存在
	 * @param newsid 动态ID
	 * @return
	 * @throws DataAccessException
	 */
	public boolean HasNew(Serializable newsid)throws DataAccessException;
	
	public SaysNews getNewsIDBynewscontent(Serializable id)throws DataAccessException;

}
