package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysFriendsDao;
import org.entity.SaysFriends;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysFriendsDaoImpl extends AbstractBaseDao<SaysFriends> implements
		ISaysFriendsDao {

	private static final String FINDBYUSERID_HQL="select f from SaysFriends f, SaysUser s where f.userid.userid=s.userid and f.userid.userid=?";
	private static final String FINDBYID_HQL="select s from SaysFriends f,SaysUser s where f.userfriendid.userid=s.userid and f.userfriendid.userid=?";
	private static final String COUNT_HQL="select count(sf) from SaysFriends sf where sf.userid.userid=?";

	@SuppressWarnings("unchecked")
	public List<SaysFriends> findbyuseridallSaysFriends(Serializable userid, int firstResult,int maxResults)
			throws DataAccessException {
		return this.findByHql(FINDBYUSERID_HQL, firstResult, maxResults,new Object[]{userid});
	}


	@Override
	public Serializable addSaysFriends(SaysFriends syasfriends)
			throws DataAccessException {
		return this.save(syasfriends);
	}


	@Override
	public boolean deletedFriendsbyid(String friendid) throws DataAccessException {
		this.deleteById(friendid);
		return true;
	}


	@Override
	public List selectbufriendsbyid(String userfriendid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
		return this.findByHql(FINDBYID_HQL, new Object[]{userfriendid});
	}


	@Override
	public int countSaysFriends(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.countByHql(COUNT_HQL, userid);
	}

	
}
