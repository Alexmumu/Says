package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFriends;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysFriendsDao extends IBaseDao<SaysFriends> {

	
	/**
	 * 1、方法：根据用户id、查询出该用户的所有好友的信息并分页
	 * @param userid 用户id
	 * @param firstResult 第一页
	 * @param maxResults 最大页
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysFriends> findbyuseridallSaysFriends(Serializable userid, int firstResult,int maxResults)throws DataAccessException;
	
	/**
	 * 2.方法：添加一个好友
	 * @param syasfriends
	 * @throws DataAccessException
	 */
	public Serializable addSaysFriends(SaysFriends syasfriends)throws DataAccessException;
	
	
	/**
	 * 3.方法：根据好友表id删除好友
	 * @param userid 好友表id
	 * @throws DataAccessException
	 */
	public void deletedFriendsbyid(String friendid)throws DataAccessException;
	
	/**
	 * 4.根据好友id，查询出好友的详细信息
	 * @param userfriendid 好友id
	 * @return
	 * @throws DataAccessException
	 */
	public List selectbufriendsbyid(String userfriendid)throws DataAccessException;
	
	/**
	 * 5.根据用户id，查询出该用户好友的数量
	 * @param userid
	 * @return
	 * @throws DataAccessException
	 */
	public int countSaysFriends(Serializable userid)throws DataAccessException;
	/**
	 * 根据用户id和好友id 查询俩用户之间的好友关系是否存在
	 * @param userid
	 * @param userfriendid
	 * @return
	 * @throws DataAccessException
	 */
	public List  selectUserAnduserfriendid(Serializable userid,Serializable userfriendid)throws DataAccessException;
	
	
}
