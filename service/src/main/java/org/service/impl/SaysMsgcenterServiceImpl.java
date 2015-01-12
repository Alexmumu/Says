package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysMsgcenterDao;
import org.entity.SaysMsgcenter;
import org.service.AbstractBaseService;
import org.service.ISaysMsgcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysMsgcenterServiceImpl extends AbstractBaseService implements
		ISaysMsgcenterService {
	
	@Autowired
	private ISaysMsgcenterDao msgcenterDao;

	@Override
	public Serializable AddMsg(SaysMsgcenter msg) {
		Serializable i = null;
		if(msgcenterDao.hasMsg(msg.getMcid())){
			i = msgcenterDao.AddMsg(msg);
		}
		return i;
	}

	@Override
	public boolean DeleteMsg(Serializable mcid) {
		try {
			msgcenterDao.deleteById(mcid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int FindNewMsg(Serializable userid) {
		return msgcenterDao.FindNewMsg(userid);
	}

	@Override
	public Page<SaysMsgcenter> FindMsgByUser(Serializable userid,
			Page<SaysMsgcenter> page) {
		page.setDataSum(msgcenterDao.CountMsg(userid));
		List<SaysMsgcenter> list = msgcenterDao.FindMsgByUser(userid, page
				.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
	}

}
