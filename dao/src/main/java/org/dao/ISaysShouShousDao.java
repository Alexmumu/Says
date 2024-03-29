package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysShuoshuo;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysShouShousDao extends IBaseDao<SaysShuoshuo> {
	/**
	 * 根据用户ID查询所有的说说
	 * @param userid 用户ID
	 * @param firstResult
	 * @param maxResults
	 * @return List<SaysShuoshuo>
	 * @throws DataAccessException
	 */
	public List<SaysShuoshuo> findAllShuoShuo(Serializable userid, int firstResult,int maxResults,int shuostatus) throws DataAccessException;
	
	/**
	 * 添加一条说说
	 * @param ss 说说的实体对象
	 * @return Serializable
	 * @throws DataAccessException
	 */
	public Serializable addShouShou(SaysShuoshuo ss)throws DataAccessException;

	
	/**
	 * 删除指定的说说
	 * @param shuoid 说说ID
	 * @throws DataAccessException
	 */
	public void delectShouShou(Serializable shuoid) throws DataAccessException;
	
	/**
	 * 修改说说
	 * @param ss 说说的实体对象
	 * @throws DataAccessException
	 */
	public void updateShouShou(SaysShuoshuo ss)throws DataAccessException;
	
	/**
	 * 根据UserId和说说状态统计说说
	 * @param userid
	 * @param shuostatus
	 * @return int
	 * @throws DataAccessException
	 */
	public int countShouShouByUserId(Serializable userid,int shuostatus)throws DataAccessException;
	
	/**
	 * 根据说说ID查询
	 * @param shouid
	 * @returnSaysShuoshuo
	 * @throws DataAccessException
	 */
	public SaysShuoshuo fingByID(Serializable shouid)throws DataAccessException;
	
	
	
	public boolean hasShuoByID(Serializable shouid);
}
