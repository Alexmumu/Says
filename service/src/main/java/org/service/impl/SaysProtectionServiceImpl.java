package org.service.impl;

import java.io.Serializable;
import java.util.List;




import org.dao.ISaysProtectionDao;
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

		return protectionDao.findSaysProtectionbyuserid(userid);
	}

	@Override
	public Serializable addnewSaysProtection(SaysProtection saysprotection)
			throws DataAccessException {
			boolean istest=false;
			if(protectionDao.findSaysProtectionbyuserid(saysprotection.getUserid().getUserid())==null)
			{
				Serializable ap= protectionDao.addSaysProtection(saysprotection);
				if(ap!=null)
				{
					istest=true;
				}
			}
			return istest; 
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
