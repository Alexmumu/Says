package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRizhi;
import org.springframework.dao.DataAccessException;
import org.vo.ContentData;
import org.vo.Page;

public interface ISaysRizhiService {
	/**
	 * 根据Saysrizhi的对象添加一条日志数据
	 * @param saysrizhi 日志表的对象
	 * @throws DataAccessException
	 */
	 public Serializable addSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException;
    
	 /**
      * 根据日志ID,查询日志的详细信息
      * @param saysrizhi 日志表的对象
      * @throws DataAccessException
      */
	 public ContentData<SaysRizhi> SaysRizhiById(Serializable rizhiid) throws DataAccessException;
    
	 /**
      * 根据日志的ID的对象修改对应的日志数据
      * @param saysrizhi 日志表的对象
      * @throws DataAccessException
      */
     public void updateSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException;
    
     /**
      * 根据用户的Id查询所有的日志
      * @param userid 用户ID
      * @param firstResult 第一页
      * @param maxResults 最大页数
      * @return 
      * @throws DataAccessException
      */
     
     public Page<SaysRizhi> findSaysRizhi(SaysRizhi srz,Page<SaysRizhi> page) throws DataAccessException;
     
     /**
      * 根据用户ID查询所有日志的个数
      * @param userid 用户ID
      * @return 返回日志的个数
      * @throws DataAccessException
      */
     public int countByUserid(Serializable userid,int rizhistatus) throws DataAccessException;
     
    /**
     * 删除日志，根据日志的ID，修改日志的状态
     * @param rizhiid 日志ID
     * @param rizhistatus 日志的状态：0代表已删除，1代表存在
     * @throws DataAccessException
     */
     public void deleteStatus(Serializable rizhiid,Serializable rizhistatus) throws DataAccessException;
     
     /**
      * 根据用户ID和日志类型的ID查询相关类型的所有日志信息
      * @param userid 用户ID
      * @param rizhitype 日志类型ID
      * @throws DataAccessException
      */
     public Page<SaysRizhi> findRizhitype(SaysRizhi srz,Page<SaysRizhi> page) throws DataAccessException;
     
 
}
