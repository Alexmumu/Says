package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFriends;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;
import org.vo.Page;

public interface ISaysFriendsService {

	/**
	 * 1.根据用户id、查询出该用户的所有好友的信息并分页
	 * @param userid
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	//public List<SaysFriends> findbyuseridallFriends(Serializable userid, int firstResult,int maxResults)throws DataAccessException;
	public Page<SaysFriends> findbyuseridallFriends(Serializable data,Page<SaysFriends> page)throws DataAccessException;
	
	
	/**
	 * 2.添加好友
	 * @param syasfriends
	 * @throws DataAccessException
	 */
	public Serializable addnewSaysFriends(SaysFriends syasfriends)throws DataAccessException;
	
	/**
	 * 3.删除好友
	 * @param userfriendid
	 * @return
	 * @throws DataAccessException
	 */
	public boolean deletedFriends(String friendid)throws DataAccessException;
	
	/**
	 * 4.根据好友id，查询出好友的详细信息
	 * @param userfriendid 好友id
	 * @return
	 * @throws DataAccessException
	 */
	public List selectbufriendsbyidinfo(String userfriendid)throws DataAccessException;
	
	/**
	 * 5.根据用户id，查询出该用户好友的数量
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	public int countSaysFriends(Serializable userid)throws DataAccessException;
	
}
