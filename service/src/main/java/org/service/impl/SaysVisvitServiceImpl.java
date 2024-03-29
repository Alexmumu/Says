package org.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dao.ISaysUserDao;
import org.dao.ISaysVisitDao;
import org.dateutil.DateUtil;
import org.entity.SaysVisit;
import org.service.ISaysUserService;
import org.service.ISaysVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.FankeVo;
import org.vo.Page;

@Service
public class SaysVisvitServiceImpl implements ISaysVisitService {

	@Autowired
	private ISaysVisitDao saysVisitDao;
	@Autowired
	private ISaysUserDao userdao;

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
	public void deleteVisitId(Serializable visitid) throws DataAccessException {
		// TODO Auto-generated method stub
		this.saysVisitDao.deleteById(visitid);
	}

	/********
	 * 处理添加，如果查到访问的好友的新这更新查到的好友访问记录的时间
	 */
	@Override
	public Serializable addSaysVisit(SaysVisit saysVisit)
			throws DataAccessException {

		List list = saysVisitDao.findByVisitId(saysVisit.getUserid()
				.getUserid(), saysVisit.getFromuserid().getUserid());
		// 获取系统最新时间
		saysVisit.setVisittime(new Timestamp(new Date().getTime()));
		if (list == null || list.size() == 0) {
			System.out.println("进入添加 访客表");
			return saysVisitDao.save(saysVisit);
		} else {
			System.out.println("已有记录 更新中。。。访客表");
			saysVisit = (SaysVisit) list.get(0);
			saysVisit.setVisittime(new Timestamp(new Date().getTime()));
			saysVisitDao.update(saysVisit);
			return saysVisit.getVisitid();
		}

	}
	
	/**
	 * 与 findSaysVisitsUseridByAndPage 方法结果相反
	 */
	@Override
	public Page<FankeVo> findMySaysVisit(SaysVisit data,
			Page<FankeVo> page) throws DataAccessException {
		page.setDataSum(saysVisitDao.countMyByUserid(data.getFromuserid().getUserid()));
		List<SaysVisit> list = saysVisitDao.findMySaysVisit(data.getFromuserid().getUserid(),page.getFirstResult(), page.getMaxResults());
		List<FankeVo> fklist=new ArrayList<FankeVo>();
		for(SaysVisit sv:list){
			FankeVo fv=new FankeVo();
			fv.setUser(sv.getFromuserid());
			fv.setFromuserid(sv.getUserid());
			System.out.println(sv.getVisittime());
			fv.setFangketime(DateUtil.getDateStr(sv.getVisittime()));
			fklist.add(fv);
		}
		page.setResult(fklist);

		return page;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<FankeVo> findSaysVisitsUseridByAndPage(SaysVisit data,
			Page<FankeVo> page) throws DataAccessException {
		// TODO Auto-generated method stub

		page.setDataSum(saysVisitDao.countByUserid(data.getUserid().getUserid()));
		List<SaysVisit> list = saysVisitDao.findSaysVisit(data.getUserid().getUserid(),page.getFirstResult(), page.getMaxResults());
		List<FankeVo> fklist=new ArrayList<FankeVo>();
		for(SaysVisit sv:list){
			FankeVo fv=new FankeVo();
			fv.setUser(sv.getUserid());
			fv.setFromuserid(sv.getFromuserid());
			fv.setFangketime(DateUtil.getDateStr(sv.getVisittime()));
			fklist.add(fv);
		}
		page.setResult(fklist);
		return page; 

	}

}
