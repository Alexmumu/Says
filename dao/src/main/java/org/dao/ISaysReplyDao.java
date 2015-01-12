package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysReply;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysReplyDao extends IBaseDao<SaysReply> {

	/**
	 * 根据评论ID查询当前评论的回复
	 * @param commentid 评论ID
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysReply> FindReplybyCommentid(Serializable commentid,int firstResult,
			int maxResults,int replystatus)throws DataAccessException;
	
	/**
	 * 根据评论ID查询当前回复数量
	 * @param commentid 评论ID
	 * @return
	 * @throws DataAccessException
	 */
	public int CountReplybyCommentid(Serializable commentid,int replystatus)throws DataAccessException;
	
	/**
	 * 根据回复ID查询当前回复的回复
	 * @param replyare 回复ID
	 * @param firstResult 第一页
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysReply> FindReplybyReplyare(Serializable replyare,int firstResult,
			int maxResults,int replystatus)throws DataAccessException;
	
	/**
	 * 根据回复ID查询当前回复数量
	 * @param replyare 回复ID
	 * @return
	 * @throws DataAccessException
	 */
	public int CountReplybyReplyare(Serializable replyare,int replystatus)throws DataAccessException;
	
	/**
	 * 添加一条新的回复
	 * @param reply SaysReply对象
	 * @throws DataAccessException
	 */
	public Serializable AddReply(SaysReply reply)throws DataAccessException;
	
	
	/**
	 * 判断当前回复是否存在
	 * @param replyid 回复ID
	 * @return
	 * @throws DataAccessException
	 */
	public boolean HasReply(Serializable replyid)throws DataAccessException;
	
}
