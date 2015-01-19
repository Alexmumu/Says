package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRizhi;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysRizhiDao extends IBaseDao<SaysRizhi> {

	 /**
      * 根据日志ID,查询日志的详细信息
      * @param saysrizhi 日志表的对象
      * @throws DataAccessException
      */
	 public SaysRizhi SaysRizhiById(Serializable rizhiid) throws DataAccessException;
    
     /**
      * 根据用户的Id查询所有的日志
      * @param userid 用户ID
      * @param firstResult 第一页
      * @param maxResults 最大页数
      * @return 
      * @throws DataAccessException
      */
     
     public List<SaysRizhi> findSaysRizhi(Serializable userid,int rizhistatus,int firstResult,int maxResults) throws DataAccessException;
     
     /**
      * 根据用户ID查询所有日志的个数
      * @param userid 用户ID
      * @return 返回日志的个数
      * @throws DataAccessException
      */
     public int countByUserid(Serializable userid,int rizhistatus) throws DataAccessException;

    
 	 public int countByUseridtype(Serializable userid,Serializable rizhitype,int rizhistatus) throws DataAccessException;
     /**
      * 根据用户ID和日志类型的ID查询相关类型的所有日志信息
      * @param userid 用户ID
      * @param rizhitype 日志类型ID
      * @throws DataAccessException
      */
     public List<SaysRizhi> findRizhitype(Serializable userid,Serializable rizhitype,int rizhistatus,int firstResult,int maxResults) throws DataAccessException;
     

     /**
      * 根据用户ID和日志类型的ID查询相关类型的所有日志信息
      * @param userid 用户ID
      * @param rizhitype 日志类型ID
      * @throws DataAccessException
      */
     public List<SaysRizhi> findRizhitypes(Serializable userid,Serializable rizhitype,int rizhistatus) throws DataAccessException;
     

     
}
