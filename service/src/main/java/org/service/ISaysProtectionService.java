package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysProtection;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysProtectionService{
	
	/**
	 * 根据用户id，查询出该用户的密保问题和答案
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysProtection> findSaysProtectionbyid(String userid)throws DataAccessException;
	
	/**
	 * 添加密保
	 * @param saysprotection
	 * @throws DataAccessException
	 */
	public Serializable addnewSaysProtection(SaysProtection saysprotection)throws DataAccessException;
	
	/**
	 * 修改密保
	 * @param saysprotection
	 * @return
	 * @throws DataAccessException
	 */
	public boolean updateSaysProtections(SaysProtection saysprotection)throws DataAccessException;
		
	
	/**
	 * 验证密保信息
	 * @param saysprotection
	 * @throws DataAccessException
	 */
	public  boolean  yanzhenSaysProtection(SaysProtection saysprotection)throws DataAccessException;
	 
	
	
	
}
