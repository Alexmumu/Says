package org.service.impl;

import java.io.Serializable;
import java.util.List;





import org.dao.ISaysProtectionDao;
import org.entity.SaysFriends;
import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ISaysProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SaysProtectionServiceImpl  implements ISaysProtectionService{

	@Autowired
	private ISaysProtectionDao protectionDao;

	@Override
	public List<SaysProtection> findSaysProtectionbyid(String userid)
			throws DataAccessException {

		List<SaysProtection> pd = protectionDao.findSaysProtectionbyuserid(userid);
		for(SaysProtection f:pd){
			protectionDao.initialize(f.getUserid());
			protectionDao.initialize(f.getQuestionno1());
			protectionDao.initialize(f.getQuestionno2());
			protectionDao.initialize(f.getQuestionno3());
			protectionDao.initialize(f.getAnswerno1());
			protectionDao.initialize(f.getAnswerno2());
			protectionDao.initialize(f.getAnswerno3());
		}
		return pd;
	}

	@Override
	public Serializable addnewSaysProtection(SaysProtection saysprotection)
			throws DataAccessException {
			boolean istest=false;
			List<SaysProtection> pp = protectionDao.findSaysProtectionbyuserid(saysprotection.getUserid().getUserid());
			if(pp.size()==0)
			{
				Serializable ap= protectionDao.addSaysProtection(saysprotection);
				System.out.println("密保添加成功！");
				istest=true;
				return istest;
			}else
			{
				System.out.println("您已设置密保无法再次添加！");
				return istest; 
			}
	}

	@Override
	public boolean updateSaysProtections(SaysProtection saysprotection)
			throws DataAccessException {
		try {
			boolean s = this.protectionDao.updateSaysProtection(saysprotection);
			return s;
		} catch (DataAccessException e) {
			return false;
		}
		
	}

	
	@Override
	public  boolean  yanzhenSaysProtection(SaysProtection saysprotection)
			throws DataAccessException {
		// TODO Auto-generated method stub
		List<SaysProtection> slist= protectionDao.findByExample(saysprotection);
		boolean istest=false;
		if(slist.size()!=0){
			  this.protectionDao.initialize(slist.get(0).getUserid());
			  if(slist.get(0).getUserid().getUserid().equals(saysprotection.getUserid().getUserid())){
				  istest=true;
				  System.out.println("成功！");
			  }
		  }
		return istest;
	}
	
	
	
}
