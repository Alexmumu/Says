package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysMsgcenter;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysMsgcenterDao extends IBaseDao<SaysMsgcenter> {

	/**
	 * 根据用户ID查询当前用户消息中心所有消息
	 * @param userid 当前用户ID
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysMsgcenter> FindMsgByUser(Serializable userid, int firstResult,
			int maxResults)throws DataAccessException ;
	
	/**
	 * 根据当前用户ID查询当前用户未读消息数量
	 * @param userid 当前用户ID
	 * @return
	 * @throws DataAccessException
	 */
	public int FindNewMsg(Serializable userid)throws DataAccessException;
	
	/**
	 * 为当前用户添加一条新的消息
	 * @param msg SaysMsgcenter对象
	 * @throws DataAccessException
	 */
	public Serializable AddMsg(SaysMsgcenter msg)throws DataAccessException;
	
	/**
	 * 查询当前msg数量
	 * @param userid 当前用户ID
	 * @return
	 * @throws DataAccessException
	 */
	public int CountMsg(Serializable userid)throws DataAccessException;
	
	
	/**
	 * 判断当前消息是否存在
	 * @param mcid 消息ID
	 * @return
	 * @throws DataAccessException
	 */
	public boolean hasMsg(Serializable mcid)throws DataAccessException;
}
