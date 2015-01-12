package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFriends;
import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;



public interface ISaysUserDao extends IBaseDao<SaysUser> {
	
	/**
	 *1.方法：用户登陆
	 *根据用户输入的用户名和密码，到用户表查询是否存在该用户
	 *@param username 用户名
	 *@param userpassword 密码
	 *@throws DataAccessException 抛出异常
	 */
	@SuppressWarnings("rawtypes")
	public List login(String username,String userpassword)throws DataAccessException;

	
	/**
	 * 2.方法：用户注册
	 * 将页面用户输入内容添加到用户表，创建一个新的用户 
	 * @param saysuser
	 * @throws DataAccessException
	 */
	public Serializable addSaysuser(SaysUser saysuser)throws DataAccessException;
	
	
	/**
	 * 3.方法：根据用户id，查询出该用户所有个人信息
	 * @param userid
	 * @throws DataAccessException
	 */
	@SuppressWarnings("rawtypes")
	public List selectSaysuser(String userid)throws DataAccessException;
	
	
	/**
	 * 4.方法：根据用户id修改该用户信息
	 * 可以修改该用户的：密码、呢称、性别、头像、个人简介、出生年月、所在地区
	 * @param saysuser
	 * @throws DataAccessException
	 */
	public void updateSaysUser(SaysUser saysuser)throws DataAccessException;
	
	/**
	 * 5.根据用户名进行模糊查询
	 * @param username  用户名
	 * @param firstResult 
	 * @param maxResults 
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysUser> mhcxSaysUser(Serializable username,int firstResult,int maxResults)throws DataAccessException;
	
	/**
	 * 6.根据用户名查询出所有用户的数量
	 * @param username
	 * @return
	 * @throws DataAccessException
	 */
	public int countSaysFriends(Serializable username)throws DataAccessException;

	/**
	 * 7.根据用户名，查询用户信息
	 * @param username
	 * @return
	 * @throws DataAccessException
	 */
	public List selectbyusername(String username)throws DataAccessException;

	
	
	
	
}
