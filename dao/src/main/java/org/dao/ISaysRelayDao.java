package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRelay;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;


/**
 * 2015/1/8
 * @author Eyser
 * 转发转载记录表的SaysRelayDao接口继承IBaseDao基本方法
 */
public interface ISaysRelayDao extends IBaseDao<SaysRelay>{
	/**
	 * 添加一条转发转载的信息
	 * @throws DataAccessException
	 */
	public void saveSaysRelay(SaysRelay ar) throws DataAccessException;
	
	/**
	 * 删除一条转发转载信息
	 * @throws DataAccessException
	 */
	public void deleteSaysRelay(Serializable relayid) throws DataAccessException;
	/**
	 * 查询转发转载表的数量
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	public int countByUseridSaysRelay(Serializable userid)throws DataAccessException;
	public int countByRelayfromSaysRelay(Serializable relayfrom)throws DataAccessException;
	public int countByRelayafterSaysRelay(Serializable relayafter)throws DataAccessException;
	public int countByRelayFromAndUseridAndUseridareSaysRelay(Serializable relayfrom,Serializable userid,Serializable useridare)throws DataAccessException;
	public int countByRelayFromAndUseridareSaysRelay(Serializable relayfrom,Serializable useridare)throws DataAccessException;
	public List<SaysRelay> FindSaysRelayByPage(Serializable relayfrom, int firstResult,
			int maxResults )throws DataAccessException;
	public List<SaysRelay> findByRelayfromSaysRelay(Serializable relayfrom)throws DataAccessException;
	/**
	 * 查询所属用户被访问的用户
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysRelay> findByUseridSaysRelay(Serializable userid)throws DataAccessException;
	public List<SaysRelay> findByUseridAndRelayafterSaysRelay(Serializable userid,Serializable relayafter)throws DataAccessException;
	
}
