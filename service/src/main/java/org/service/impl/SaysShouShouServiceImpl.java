package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysShouShousDao;
import org.entity.SaysAlbum;
import org.entity.SaysShuoshuo;
import org.service.AbstractBaseService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysShouShouServiceImpl extends AbstractBaseService implements IsaysShouShouService {
 
	@Autowired
	private ISaysShouShousDao shoushouDao;
  
 
	@Override
	public void updateShouShou(SaysShuoshuo ss) {
		shoushouDao.updateShouShou(ss);
		
	}
	@Override
	public int countShouShouByUserId(Serializable userid, int shuostatus) {
		// TODO Auto-generated method stub
		return shoushouDao.countShouShouByUserId(userid, shuostatus);
	}

	@Override
	public Serializable addShouShou(SaysShuoshuo ss) {
		// TODO Auto-generated method stub
		return shoushouDao.addShouShou(ss);
	}
	
	@Override
	public Page<SaysShuoshuo> findAllShuoShuo(SaysShuoshuo ss,
			Page<SaysShuoshuo> page, int shuostatus) {
		page.setDataSum(shoushouDao.countShouShouByUserId(ss.getUserid().getUserid(), 1));
		 List<SaysShuoshuo> list = shoushouDao.findAllShuoShuo(ss.getUserid().getUserid(), page.getFirstResult(), page.getMaxResults(),shuostatus);
       page.setResult(list);
		System.out.println(page.getDataSum());
		System.out.println(page.getPageSum());
		return page;
	}

}
