package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysUserDao;
import org.entity.SaysUser;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysUserDaoImpl extends AbstractBaseDao<SaysUser> implements
	ISaysUserDao{

	private static final String LOGIN_HQL="select u from SaysUser u where u.username=? and u.userpassword=?";
	private static final String USERINFO_HQL="select u from SaysUser u where u.userid=?";
	private static final String USER_HQL="select u from SaysUser u where u.username like ?";
	private static final String COUNT_HQL="select count(su) from SaysUser su where su.username like ?";
	private static final String BYUSERNAME_HQL="select u from SaysUser u where u.username =?";
	
	@SuppressWarnings("rawtypes")
	@Override
	public List login(String username, String userpassword)throws DataAccessException {
		return this.findByHql(LOGIN_HQL, username,userpassword);
				
	}
	
	
	@Override
	public Serializable addSaysuser(SaysUser saysuser) throws DataAccessException {
		Boolean istest=false;
		Serializable aa=this.save(saysuser);
		if(aa!=null)
		{
			istest=true;
		}
		return istest;
	}


	@Override
	public void updateSaysUser(SaysUser saysuser) throws DataAccessException {
		this.update(saysuser);
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List selectSaysuser(String userid) throws DataAccessException {
		return this.findByHql(USERINFO_HQL, userid);
	}


	@Override
	public List<SaysUser> mhcxSaysUser(Serializable username,int firstResult, int maxResults)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
		return this.findByHql(USER_HQL, firstResult, maxResults,new Object[]{"%"+username+"%"});
	}

	@Override
	public int countSaysFriends(Serializable username)throws DataAccessException {
		// TODO Auto-generated method stub
		
		return this.countByHql(COUNT_HQL, new Object[]{"%"+username+"%"});
	}


	@Override
	public List selectbyusername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.findByHql(BYUSERNAME_HQL, username);
	}

	
	



	
	
	

}
