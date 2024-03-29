package org.dao;

import java.io.Serializable;

import java.util.List;

import org.entity.SaysVisit;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysVisitDao extends IBaseDao<SaysVisit> {
	
	/**
	 * 根据用户ID，查询用户自己所有的访客记录
	 * @param usetid 用户ID
	 * @param firstResult 当前页数
	 * @param maxResults 最大页数
	 * @return list集合
	 * @throws DataAccessException
	 */
	public List<SaysVisit> findSaysVisit(Serializable userid, int firstResult,int maxResults) throws DataAccessException;

	/**
	 * 根据用户ID，查询我看过的好友记录
	 * @param usetid 用户ID
	 * @param firstResult 当前页数
	 * @param maxResults 最大页数
	 * @return list集合
	 * @throws DataAccessException
	 */
	public List<SaysVisit> findMySaysVisit(Serializable fromuserid, int firstResult,int maxResults) throws DataAccessException;

	
	/**
	 * 根据用户ID统计访客的数目
	 * @param userid 用户ID
	 * @return 访客的数目
	 * @throws DataAccessException
	 */
	 public int countByUserid(Serializable userid) throws DataAccessException;
	 
	/**
	 * 根据用户ID统计我访问过好友记录的数目
	 * @param userid 用户ID
	 * @return 访客的数目
	 * @throws DataAccessException
	 */
	 public int countMyByUserid(Serializable fromuserid) throws DataAccessException;

	 /**
	  * 根据访问的用户ID查询是否有过访问记录，如果有就修改用户的用的当前时间updateVisitIdTime()
	  * @param fromuserid 访问的用户ID
	  * @return 一条数据
	  * @throws DataAccessException
	  */
	 public List<SaysVisit> findByVisitId(Serializable userid,Serializable fromuserid) throws DataAccessException;
	 


}
