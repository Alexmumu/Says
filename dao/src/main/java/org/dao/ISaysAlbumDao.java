package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysAlbum;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;
public interface ISaysAlbumDao extends IBaseDao<SaysAlbum>{
	/**
	 * 根据用户ID查询相册
	 * @param userid 用户ID
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @return
	 * @throws DataAccessException
	 */
	 public List<SaysAlbum> findByUserId(Serializable userid, int firstResult,int maxResults) throws DataAccessException;
	/**
	 * 根据用户ID统计相册数目
	 * @param userid 用户ID
	 * @return 相册数目
	 * @throws DataAccessException
	 */
	 public int countByUserid(Serializable userid)throws DataAccessException;
	
}
