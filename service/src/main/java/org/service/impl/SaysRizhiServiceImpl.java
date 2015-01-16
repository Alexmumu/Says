package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysNewsDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysRizhitypeDao;
import org.entity.SaysNews;
import org.entity.SaysRizhi;
import org.entity.SaysUser;
import org.hibernate.event.Initializable;
import org.service.ISaysRizhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysRizhiServiceImpl implements ISaysRizhiService {

	@Autowired
	private ISaysRizhiDao saysRizhiDao; 
	@Autowired
	private ISaysRizhitypeDao saysRizhitypeDao; 
	
	@Autowired
	private ISaysNewsDao saysNewsDao;
	
	@Override
	public Serializable addSaysRizhi(SaysRizhi saysrizhi)
			throws DataAccessException {
		// TODO Auto-generated method stub
		Serializable a=this.saysRizhiDao.save(saysrizhi);
		System.out.println(a+"uuid");
		//添加一条动态信息
		    SaysNews news = new SaysNews();
			news.setNewscontent((String)a);
			SaysUser user = new SaysUser();
			user.setUserid(saysrizhi.getRizhiuserid().getUserid());
		    news.setUserid(user);
		    news.setNewsstatus(4);
			saysNewsDao.AddNew(news);
		return a;
	}

	@Override
	public SaysRizhi SaysRizhiById(Serializable rizhiid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		SaysRizhi rz=this.saysRizhiDao.SaysRizhiById(rizhiid);
		saysRizhiDao.initialize(rz.getRizhiuserid().getUserid());
		saysRizhiDao.initialize(rz.getRizhitype());
		return rz;
	}

	@Override
	public void updateSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException {
		// TODO Auto-generated method stub
           this.saysRizhiDao.update(saysrizhi);;
	}

	
	@Override
	public int countByUserid(Serializable userid, int rizhistatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.saysRizhiDao.countByUserid(userid, rizhistatus);
	}

	@Override
	public void deleteStatus(Serializable rizhiid, Serializable rizhistatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		SaysRizhi saysRizhi=this.saysRizhiDao.getById(rizhiid);
		saysRizhi.setRizhistatus(0);
		System.out.println(saysRizhi.getRizhistatus());
	    this.saysRizhiDao.update(saysRizhi);;

	}


	@Override
	public Page<SaysRizhi> findRizhitype(SaysRizhi srz,Page<SaysRizhi> page)  throws DataAccessException {
		// TODO Auto-generated method stub
		page.setDataSum(saysRizhiDao.countByUserid(srz.getRizhiuserid().getUserid(),srz.getRizhistatus()));
		List<SaysRizhi> list = saysRizhiDao.findRizhitype(srz.getRizhiuserid().getUserid(),srz.getRizhitype().getTypeid(),srz.getRizhistatus(),page.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		for(SaysRizhi rz:list){
			saysRizhitypeDao.initialize(rz.getRizhitype());
			}
		return page;
	}
	@Override
	public Page<SaysRizhi> findSaysRizhi(SaysRizhi srz,Page<SaysRizhi> page) throws DataAccessException {
		// TODO Auto-generated method stub
		page.setDataSum(saysRizhiDao.countByUserid(srz.getRizhiuserid().getUserid(),srz.getRizhistatus()));
		List<SaysRizhi> list = saysRizhiDao.findSaysRizhi(srz.getRizhiuserid().getUserid(), srz.getRizhistatus(), page.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		for(SaysRizhi rz:list){
			saysRizhitypeDao.initialize(rz.getRizhitype());
			}
		return page;
	}





}
