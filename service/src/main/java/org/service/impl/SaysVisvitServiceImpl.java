package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysVisitDao;
import org.entity.SaysVisit;
import org.service.ISaysVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysVisvitServiceImpl implements ISaysVisitService {

	@Autowired
	private ISaysVisitDao saysVisitDao;
	


	@Override
	public int countByUserid(Serializable userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return saysVisitDao.countByUserid(userid);
	}

	@Override
	public int countMyByUserid(Serializable fromuserid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return saysVisitDao.countMyByUserid(fromuserid);
	}


	@Override
	public void updateVisitIdTime(SaysVisit saysVisit)
			throws DataAccessException {
		// TODO Auto-generated method stub
		this.saysVisitDao.updateVisitIdTime(saysVisit);

	}

	@Override
	public void deleteVisitId(Serializable visitid) throws DataAccessException {
		// TODO Auto-generated method stub
		this.saysVisitDao.deleteVisitId(visitid);
	}
	/********
	 * 处理添加，如果查到访问的好友的新这更新查到的好友访问记录的时间
	 */
	@Override
	public Serializable addSaysVisit(SaysVisit saysVisit) throws DataAccessException {
		// TODO Auto-generated method stub

		 return saysVisitDao.addSaysVisit(saysVisit);

	}

	@Override
	public Page<SaysVisit> fandMySaysVisit(SaysVisit data,
			Page<SaysVisit> page) throws DataAccessException {
		// TODO Auto-generated method stub
		page.setDataSum(saysVisitDao.countMyByUserid(data.getFromuserid().getUserid()));
		List<SaysVisit> list = saysVisitDao.fandSaysVisit(data.getFromuserid().getUserid(),page.getFirstResult(), page.getMaxResults());
		return page;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<SaysVisit> findSaysVisitsUseridByAndPage(SaysVisit data,
			Page<SaysVisit> page) throws DataAccessException {
		// TODO Auto-generated method stub
		page.setDataSum(saysVisitDao.countByUserid(data.getUserid().getUserid()));
		List<SaysVisit> list = saysVisitDao.fandSaysVisit(data.getUserid().getUserid(),page.getFirstResult(), page.getMaxResults());
		return page; 
	}





}
