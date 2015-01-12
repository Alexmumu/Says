package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysComments;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysCommentsDao extends IBaseDao<SaysComments> {

	/**
	 * 根据项目ID查询该项目的所有评论
	 * @param commentsforid 项目ID
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysComments> FindComments(Serializable commentsforid, int firstResult,
			int maxResults,String commentstatus )throws DataAccessException;
	
	/**
	 * 查询当前评论的数量
	 * @param commentsforid 项目ID
	 * @return
	 * @throws DataAccessException
	 */
	public int CountComments(Serializable commentsforid,String commentstatus)throws DataAccessException;
	
	
	/**
	 * 添加一条新的评论
	 * @param comment SaysComments对象
	 * @throws DataAccessException
	 */
	public Serializable AddComments(SaysComments comment)throws DataAccessException;
	
	/**
	 * 判断当前评论是否存在
	 * @param commentid 评论ID
	 * @return
	 * @throws DataAccessException
	 */
	public boolean HasComment(Serializable commentid)throws DataAccessException;
}
