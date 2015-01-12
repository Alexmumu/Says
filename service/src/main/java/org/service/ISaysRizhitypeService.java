package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRizhitype;
import org.springframework.dao.DataAccessException;

public interface ISaysRizhitypeService {
	
	/**
	 * 根据用户ID查询，查询日志类型，时间的倒序排列
	 * @param userid 用户ID
	 * @param typestatus
	 * @return
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
	 * 删除日志类型，改变日志类型的状态
	 * @param typeid 日志类型的ID
	 * @param typestatus 日志类型的状态：0代表删除，1代表正常，2代表不可删除。
	 * @throws DataAccessException
	 */
	public void deleteRizhitype(SaysRizhitype rizhitype) throws DataAccessException;
  
	/**
	 * 根据用户ID查询日志类型的数量
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
    public int countByUserid(Serializable userid,Serializable typestatus) throws DataAccessException;

}
