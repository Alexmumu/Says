package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysFrequestDao;
import org.dao.ISaysFriendsDao;
import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.hibernateUtil.AbstractBaseDao;
import org.service.ISaysFrequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysFrequestServiceImpl implements ISaysFrequestService{

	@Autowired
	private ISaysFrequestDao frequestDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Serializable addnewSaysFrequest(SaysFrequest saysfrequest)
			throws DataAccessException {
		
		List<SaysFrequest> sp=frequestDao.selectbyfruerandfruserare(saysfrequest.getFruser().getUserid(), saysfrequest.getFruserare().getUserid());
		
		for(SaysFrequest f:sp){
			frequestDao.initialize(f.getFrid());
			frequestDao.initialize(f.getFruser());
			frequestDao.initialize(f.getFruserare());
			
		}
			Serializable f=frequestDao.addSaysFrequest(saysfrequest);
			if(f!=null)
			{
				System.out.println("申请记录添加成功！");	
				
			}	
			return  f;
		
	}

	@Override
	public boolean deletedSaysFrequestbyfrid(String frid)
			throws DataAccessException {
		
		return frequestDao.deletedSaysFrequest(frid);
	}

	@Override
	public Page<SaysFrequest> selectSaysFrequestall(Serializable data,Page<SaysFrequest> page) 
			throws DataAccessException{
	
		page.setDataSum(frequestDao.countSaysFrequest(data));
		
		List<SaysFrequest> ft=frequestDao.selectSaysFrequest(data, page
				.getFirstResult(), page.getMaxResults());
		
		for (SaysFrequest f:ft) {
			frequestDao.initialize(f.getFruserare());
		}
		
		if(ft.size()==0)
		{
			System.out.println("没有事情记录！");
		}
		page.setResult(ft);
		System.out.println(page.getDataSum()+"haha");
		return page;
		
	}

	@Override
	public List selectSaysFrequestbyid(String frid) throws DataAccessException {
		
		return frequestDao.selectSaysFrequest2(frid);
	}

	@Override
	public void updateSaysFrequestbyfrstatus(SaysFrequest saysfrequest)
			throws DataAccessException {
		
		frequestDao.updateSaysFrequest(saysfrequest);
	}

	@Override
	public int countSaysFrequest(Serializable fruser)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return frequestDao.countSaysFrequest(fruser);
	}

	@Override
	public List selectbyfruerandfruserare2(String fruser,
			String fruserare) throws DataAccessException {
		// TODO Auto-generated method stub
		
		List p=frequestDao.selectbyfruerandfruserare(fruser, fruserare);
		
		if(p.size()==0)
		{
			System.out.println("没有该申请记录");
		}
		return p;
	}

	

	
	
}
