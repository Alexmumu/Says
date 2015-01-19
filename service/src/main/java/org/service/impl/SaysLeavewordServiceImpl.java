package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysLeavewordDao;
import org.entity.SaysLeaveword;
import org.service.AbstractBaseService;
import org.service.ISaysLeavewordService;
import org.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SaysLeavewordServiceImpl extends AbstractBaseService implements ISaysLeavewordService {
	@Autowired
	private ISaysLeavewordDao saysLeavewordDao;
	@Override
	public Page<SaysLeaveword> findAllSaysLeaveword(Page<SaysLeaveword> page,SaysLeaveword sysleaveword) {
		page.setPageSum(saysLeavewordDao.countAllSaysLeaveword(sysleaveword.getUserid().getUserid(), sysleaveword.getLevewodidstatus()));
		List<SaysLeaveword> list=this.saysLeavewordDao.findSaysLeavewords(page.getFirstResult(),page.getMaxResults(), sysleaveword.getUserid().getUserid(), sysleaveword.getLevewodidstatus());
		for(SaysLeaveword sl:list){
			//sl.setUserid(null);
			saysLeavewordDao.initialize(sl.getFromuserid());
		}
		page.setResult(list);	
		return page;
	}
	@Override
	public void saveSaysLeaveword(SaysLeaveword sl) {
		
		saysLeavewordDao.saveSaysLeaveword(sl);
		
	}
	
	@Override
	public void deleteSaysLeaveword(Serializable leavewordid) {
		SaysLeaveword saysLeaveword=this.saysLeavewordDao.getById(leavewordid);
		saysLeaveword.setLevewodidstatus(0);
		this.saysLeavewordDao.update(saysLeaveword);
		//this.saysLeavewordDao.deleteSaysLeaveword(leavewordid);
		
	}
	
	@Override
	public int countAllSaysLeaveword(Serializable userid,
			Serializable levewodidstatus) {
		return this.saysLeavewordDao.countAllSaysLeaveword(userid, levewodidstatus);
		
	}
}
