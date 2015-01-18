package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysVisit;
import org.springframework.dao.DataAccessException;
import org.vo.FankeVo;
import org.vo.Page;

public interface ISaysVisitService {
	
	/**
	 * 根据用户ID，查询用户自己所有的访客记录
	 * @param usetid 用户ID
	 * @param firstResult 当前页数
	 * @param maxResults 最大页数
	 * @return list集合
	 * @throws DataAccessException
	 */
	public Page<FankeVo> findSaysVisitsUseridByAndPage(SaysVisit data,Page<FankeVo> page) throws DataAccessException;
	//public List<SaysVisit> fandSaysVisit(Serializable userid, int firstResult,int maxResults) throws DataAccessException;

	/**
	 * 根据用户ID，查询我看过的好友记录
	 * @param usetid 用户ID
	 * @param firstResult 当前页数
	 * @param maxResults 最大页数
	 * @return list集合
	 * @throws DataAccessException
	 */

	Page<FankeVo> findMySaysVisit(SaysVisit data, Page<FankeVo> page) throws DataAccessException;

	
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
	  * 添加一条访客记录
	  * @param saysVisit 访客表的对象
	  * @throws DataAccessException
	  */
	 public Serializable addSaysVisit(SaysVisit saysVisit) throws DataAccessException;
    /**
      * 根据访问客标的ID删除访问记录  真的删除
      * @param fromuserid
      * @return
      * @throws DataAccessException
      */
	 public void deleteVisitId(Serializable visitid) throws DataAccessException;



}
