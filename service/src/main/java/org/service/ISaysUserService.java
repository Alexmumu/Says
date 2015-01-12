package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.springframework.dao.DataAccessException;
import org.vo.Page;



public interface ISaysUserService{
	
	/**
	 * 用户登陆
	 * @param username
	 * @param userpassword
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("rawtypes")
	public List loginuser(String username,String userpassword)throws DataAccessException;
	
	/**
	 * 用户注册
	 * @param saysuser
	 * @return
	 * @throws DataAccessException
	 */
	public Serializable addnewSaysuser(SaysUser saysuser)throws DataAccessException;
	
	/**
	 * 根据用户id查询用户信息
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("rawtypes")
	public List selectSaysuserbyid(String userid)throws DataAccessException;
	
	/**
	 * 修改用户信息
	 * @param saysuser
	 * @throws DataAccessException
	 */
	public void updateSaysUserinfo(SaysUser saysuser)throws DataAccessException;
	
	/**
	 * 5.根据用户名进行模糊查询
	 * @param username  用户名
	 * @param firstResult 
	 * @param maxResults 
	 * @return
	 * @throws DataAccessException
	 */
	public Page<SaysUser> mhcxSaysUserinfo(Serializable username,Page<SaysUser> page)throws DataAccessException;
	
	/**
	 * 6.根据用户名查询出所有用户的数量
	 * @param username
	 * @return
	 * @throws DataAccessException
	 */
	public int countSaysFriendssl(Serializable username)throws DataAccessException;

	/**
	 * 7.根据用户名，查询用户信息
	 * @param username
	 * @return
	 * @throws DataAccessException
	 */
	public List selectbyname(String username)throws DataAccessException;

	
}
