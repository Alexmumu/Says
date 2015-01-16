package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRelayDao;
import org.entity.SaysRelay;
import org.service.ISaysRelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	

}
