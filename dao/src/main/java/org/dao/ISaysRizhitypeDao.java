package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRizhitype;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysRizhitypeDao extends IBaseDao<SaysRizhitype> {
	
	/**
	 *根据用户ID查询，查询日志类型，时间的倒序排列
	 * @param userid 用户id
	 * @return 日志类型的集合
	 * @throws DataAccessException
	 */
	public List<SaysRizhitype> find(Serializable userid,Serializable typestatus) throws DataAccessException;
	
	/**
	 * 添加一个日志类型
	 * @param saysRizhitype 日志表的对象
	 * @throws DataAccessException
	 */
	public Serializable addRizhitype(SaysRizhitype saysRizhitype) throws DataAccessException;
	
	/**
	 * 修改日志类型的信息
	 * @param saysRizhitype 日志表的对象
	 * @throws DataAccessException
	 */
	public void updataRizhitype(SaysRizhitype saysRizhitype) throws DataAccessException;
	

	/**
	 * 根据日志类型的ID查询日志类型的详细信息
	 * @param typeid 日志类型ID
	 * @return List集合的get(0)对象
	 * @throws DataAccessException
	 */
	public SaysRizhitype fandBytype(Serializable typeid) throws DataAccessException;

	/**
	 * 根据用户ID和日志类型的名字查询类型是否存在
	 * @param typeid 日志类型ID
	 * @return List集合的get(0)对象
	 * @throws DataAccessException
	 */
	public  List<SaysRizhitype>  fandBytypename(Serializable userid,Serializable typename) throws DataAccessException;

	/**
	 * 根据用户ID查询日志类型的数量
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
    public int countByUserid(Serializable userid,Serializable typestatus) throws DataAccessException;
}
