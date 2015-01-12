package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRizhiDao;
import org.entity.SaysRizhi;
import org.service.ISaysRizhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysRizhiServiceImpl implements ISaysRizhiService {

	@Autowired
	private ISaysRizhiDao saysRizhiDao; 
	
	@Override
	public Serializable addSaysRizhi(SaysRizhi saysrizhi)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.saysRizhiDao.addSaysRizhi(saysrizhi);
	}

	@Override
	public SaysRizhi SaysRizhiById(Serializable rizhiid)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.saysRizhiDao.SaysRizhiById(rizhiid);
	}

	@Override
	public void updateSaysRizhi(SaysRizhi saysrizhi) throws DataAccessException {
		// TODO Auto-generated method stub
           this.saysRizhiDao.updateSaysRizhi(saysrizhi);
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
		return page;
	}
	@Override
	public Page<SaysRizhi> fandSaysRizhi(SaysRizhi srz,Page<SaysRizhi> page) throws DataAccessException {
		// TODO Auto-generated method stub
		page.setDataSum(saysRizhiDao.countByUserid(srz.getRizhiuserid().getUserid(),srz.getRizhistatus()));
		List<SaysRizhi> list = saysRizhiDao.fandSaysRizhi(srz.getRizhiuserid().getUserid(), srz.getRizhistatus(), page.getFirstResult(), page.getMaxResults());
		return page;
	}





}
