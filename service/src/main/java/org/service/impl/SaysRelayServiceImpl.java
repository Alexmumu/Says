package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRelayDao;
import org.entity.SaysComments;
import org.entity.SaysLeaveword;
import org.entity.SaysRelay;
import org.entity.SaysReply;
import org.service.ISaysRelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;
@Service
public class SaysRelayServiceImpl implements ISaysRelayService{
	@Autowired
	ISaysRelayDao saysRelayDao;
	@Override
	public void saveSaysRelay(SaysRelay ar) {
		this.saysRelayDao.saveSaysRelay(ar);
		
	}

	@Override
	public void deleteSaysRelay(Serializable relayid) {
		this.saysRelayDao.deleteSaysRelay(relayid);
		
	}

	@Override
	public int countByUseridSaysRelay(Serializable userid) {
		
		return this.saysRelayDao.countByUseridSaysRelay(userid);
	}

	@Override
	public List<SaysRelay> findByUseridSaysRelay(Serializable userid) {
		// TODO Auto-generated method stub
		return this.saysRelayDao.findByUseridSaysRelay(userid);
	}

	@Override
	public int countByRelayfromSaysRelay(Serializable relayfrom) {
		return this.saysRelayDao.countByRelayfromSaysRelay(relayfrom);
	}

	@Override
	public int countByRelayafterSaysRelay(Serializable relayafter) {
		return this.saysRelayDao.countByRelayfromSaysRelay(relayafter);
	}

	@Override
	public List<SaysRelay> findByUseridAndRelayafterSaysRelay(
			Serializable userid, Serializable relayafter) {
			return this.findByUseridAndRelayafterSaysRelay(userid, relayafter);
	}

	@Override
	public int countByRelayFromAndUseridAndUseridareSaysRelay(Serializable relayfrom,
			Serializable userid, Serializable useridare) {
		return this.saysRelayDao.countByRelayFromAndUseridAndUseridareSaysRelay(relayfrom, userid, useridare);
	}

	@Override
	public int countByRelayFromAndUseridareSaysRelay(Serializable relayfrom,
			Serializable useridare) {
		 return this.saysRelayDao.countByRelayFromAndUseridareSaysRelay(relayfrom, useridare);
		
	}

	@Override
	public Page<SaysRelay> findCommentsByPage(Serializable relayfrom,
			Page<SaysRelay> page) {
		page.setDataSum(saysRelayDao.countByRelayfromSaysRelay(relayfrom));
		List<SaysRelay> list = saysRelayDao.FindSaysRelayByPage(relayfrom, page.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		for(SaysRelay sl:list){
			//sl.setUserid(null);
			saysRelayDao.initialize(sl.getUserid());
			saysRelayDao.initialize(sl.getUseridare());
		}
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
		
	}


}
