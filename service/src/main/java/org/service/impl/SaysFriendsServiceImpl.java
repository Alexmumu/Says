package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysFriendsDao;
import org.entity.SaysFriends;
import org.hibernateUtil.AbstractBaseDao;
import org.service.ISaysFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysFriendsServiceImpl implements ISaysFriendsService {
	
	@Autowired
	private ISaysFriendsDao friendsDao;

	@Override
	public Page<SaysFriends> findbyuseridallFriends(Serializable data,Page<SaysFriends> page)
			throws DataAccessException{
		
		page.setDataSum(friendsDao.countSaysFriends(data));
		
		List<SaysFriends> fd=friendsDao.findbyuseridallSaysFriends(data, page
				.getFirstResult(), page.getMaxResults());
		for(SaysFriends f:fd){
			friendsDao.initialize(f.getFriendid());
			friendsDao.initialize(f.getUserid());
			friendsDao.initialize(f.getUserfriendid());
		}
		
		if(fd.size()==0)
		{
			System.out.println("您当前没有好友！");
		}
		page.setResult(fd);
		System.out.println(page.getDataSum()+"haha");
		return page;
		
	}

	@Override
	public Serializable addnewSaysFriends(SaysFriends syasfriends)
			throws DataAccessException {
		
		
		List i=friendsDao.selectbufriendsbyid(syasfriends.getUserfriendid().getUserid());
		
		if(i.size()!=0)
		{
			System.out.println("该好友已存在");
		}else{
			Serializable addf=friendsDao.addSaysFriends(syasfriends);
			if(addf!=null)
			{
				System.out.println("好友添加成功");
				
			}
		}
		return syasfriends;
		
	}

	@Override
	public void deletedFriends(String friendid)
			throws DataAccessException {
		
		 friendsDao.deletedFriendsbyid(friendid);
		
	}

	@Override
	public List selectbufriendsbyidinfo(String userfriendid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return friendsDao.selectbufriendsbyid(userfriendid);
	}

	@Override
	public int countSaysFriends(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return friendsDao.countSaysFriends(userid);
	}

	
	
}
