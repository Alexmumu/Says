package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysRizhiDao;
import org.dao.ISaysRizhitypeDao;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.service.ISaysRizhitypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SaysRizhitypeServiceImpl implements ISaysRizhitypeService {

	@Autowired
	private ISaysRizhitypeDao saysRizhitypeDao;
	@Autowired
	private ISaysRizhiDao saysRizhiDao;
	
	@Override
	public List<SaysRizhitype> find(Serializable userid, Serializable typestatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return saysRizhitypeDao.find(userid, typestatus);
	}


	@Override
	public void updataRizhitype(SaysRizhitype saysRizhitype)
			throws DataAccessException {
		// TODO Auto-generated method stub
		int i = saysRizhitypeDao.fandBytypename(saysRizhitype.getUserid().getUserid(), saysRizhitype.getTypename()).size();
		if(i>0){
		System.out.println("此类型已存在");
		throw new RuntimeException("此类型已存在");
		}else{
			saysRizhitypeDao.updataRizhitype(saysRizhitype);
		}

	}

	@Override
	public void deleteRizhitype(SaysRizhitype rizhitype)
			throws DataAccessException {
		
		int i = 0;
		List<SaysRizhi> list = this.saysRizhiDao.findRizhitypes(rizhitype.getUserid().getUserid(), rizhitype.getTypeid(),0);
		
		for(SaysRizhi srz:list){
			srz.setRizhistatus(1);
			SaysRizhitype srzts = new SaysRizhitype();
			srzts.setTypeid("T001");
			srz.setRizhitype(srzts);
			this.saysRizhiDao.update(srz);
		}
		SaysRizhitype rzt = this.saysRizhitypeDao.getById(rizhitype.getTypeid());
		rzt.setTypestatus(0);
		this.saysRizhitypeDao.update(rzt);
	}

	@Override
	public int countByUserid(Serializable userid, Serializable typestatus)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return saysRizhitypeDao.countByUserid(userid, typestatus);
	}

	@Override
	public Serializable addRizhitype(SaysRizhitype saysRizhitype)
			throws DataAccessException {
		// TODO Auto-generated method stub
		int i = saysRizhitypeDao.fandBytypename(saysRizhitype.getUserid().getUserid(), saysRizhitype.getTypename()).size();
		if(i>0){
			System.out.println("此类型已存在");
			throw new RuntimeException("此类型已存在");
			}else{
		  return  saysRizhitypeDao.addRizhitype(saysRizhitype);
		}
		
	}


}
