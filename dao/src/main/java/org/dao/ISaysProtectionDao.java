package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysProtection;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysProtectionDao extends IBaseDao<SaysProtection> {
	
	
	/**
	 * 1.方法：根据用户id，查询出该用户的密保问题和答案
	 * @param userid  用户id
	 * @return 
	 */
	public List<SaysProtection> findSaysProtectionbyuserid(String userid)throws DataAccessException;
	
	
	/**
	 * 2.方法：添加密保问题和答案
	 * @param saysprotection 
	 * @throws DataAccessException
	 */
	public Serializable addSaysProtection(SaysProtection saysprotection)throws DataAccessException;
	
	
	/**
	 * 3.方法：根据用户id，修改该用户的密保问题和答案
	 * @param saysprotection
	 * @throws DataAccessException
	 */
	public boolean updateSaysProtection(SaysProtection saysprotection)throws DataAccessException;
	
	
}
