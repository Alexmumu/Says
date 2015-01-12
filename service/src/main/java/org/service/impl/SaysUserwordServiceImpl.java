package org.service.impl;

import java.io.Serializable;

import org.dao.ISaysUserwordDao;
import org.entity.SaysUserword;
import org.service.ISaysUserwordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SaysUserwordServiceImpl implements ISaysUserwordService {
	@Autowired
	ISaysUserwordDao saysUserwordDao;
	@Override
	public void saveSaysUserword(SaysUserword suw) {
		if(this.saysUserwordDao.findSaysUserwordByUserId1(suw.getUserid().getUserid())>0)
			{
				System.out.println("已经有寄语了");
			}
			else
		this.saysUserwordDao.saveSaysUserword(suw);
		
	}

	@Override
	public void updateSaysUserword(SaysUserword saysUserword) {
		this.saysUserwordDao.updateSaysUserword(saysUserword);
		
	}

	@Override
	public SaysUserword findSaysUserwordByUserId(Serializable userid) {
		
		return this.saysUserwordDao.findSaysUserwordByUserId(userid);
	}

}
