package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysPhoto;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysPhotoDao extends IBaseDao<SaysPhoto>{
	/**
	 * 根据相册的ID查询相册里面的照片
	 * @param albumid  相册ID
	 * @return List<SaysPhoto>
	 * @throws DataAccessException
	 */
	public List<SaysPhoto> findPhotoByAlbumId(Serializable albumid,int firstResult,int maxResults)throws DataAccessException;

	
	/**
	 * 跟指定的相册添加图片
	 * @param ph 照片的实体对象
	 * @return Serializable
	 * @throws DataAccessException
	 */
	public Serializable addPhotoIntoAlbum(SaysPhoto ph)throws DataAccessException;
	
	
	/**
	 * 修改指定的照片信息
	 * @param ph 照片的实体对象
	 * @throws DataAccessException
	 */
	public void updatePhoto(SaysPhoto ph)throws DataAccessException;
	
	/**
	 * 删除指定的照片
	 * @param photoid 照片的ID
	 * @throws DataAccessException
	 */
	public void deletPhoto(Serializable photoid)throws DataAccessException;
	
	/**
	 * 转移照片到指定的相册
	 * @param photoid 照片的ID
	 * @param albumid  相册的ID
	 * @throws DataAccessException
	 */
	
	
	//public void updatePhotoIsAlbum(Serializable photoid,Serializable albumid) throws DataAccessException;
}
