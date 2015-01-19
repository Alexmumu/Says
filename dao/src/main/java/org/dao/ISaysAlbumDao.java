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
	 public List<SaysAlbum> findByUserId(Serializable userid, int firstResult,int maxResults,int albumstatus) throws DataAccessException;
	/**
	 * 根据用户ID统计相册数目
	 * @param userid 用户ID
	 * @return 相册数目
	 * @throws DataAccessException
	 */
	 public int countByUserid(Serializable userid ,int albumstatus )throws DataAccessException;
	 

	 /**
	  * 添加一个相册
	  * @param al
	  * @return
	  * @throws DataAccessException
	  */
	 public Serializable addAlbum(SaysAlbum al) throws DataAccessException;
	
	/**
	 *  根据相册ID删除相册，包括里面的照片
	 * @param albumid 相册ID
	 * @throws DataAccessException
	 */
	 public void delectAlbum(Serializable albumid)throws DataAccessException;
	 
	 
	 /**
	  * 修改相册信息
	  * @param al 相册ID
	  * @return
	  * @throws DataAccessException
	  */
	 public void updateAlbum(SaysAlbum al) throws DataAccessException;
	 
	 /**
	  * 根据相ID查询要修改的信息
	  * @param albumid
	  * @return SaysAlbum
	  * @throws DataAccessException
	  */
	 public SaysAlbum findAlbumByalbumid(Serializable albumid)throws DataAccessException;
	 
	 
	 public SaysAlbum getAlbumByuserid(Serializable userid)throws DataAccessException;
}
