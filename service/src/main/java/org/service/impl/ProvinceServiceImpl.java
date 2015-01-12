package org.service.impl;

import java.util.List;

import org.dao.IProvinceDao;
import org.entity.City;
import org.entity.Province;
import org.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private IProvinceDao provinceDao;
	
	@Override
	public List<Province> findProvince() throws DataAccessException {
		// TODO Auto-generated method stub
		return provinceDao.findProvince();
	}
	@Override
	public void saveProvince(Province data) {
		 this.provinceDao.save(data);
		 throw new RuntimeException("测试事务");
	}

}
