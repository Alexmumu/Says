package org.service.impl;

import java.util.List;

import org.dao.ICityDao;
import org.entity.City;
import org.service.AbstractBaseService;
import org.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CityServiceImpl extends AbstractBaseService implements ICityService {
	@Autowired
	private ICityDao cityDao;
	

	@Override
	public List<City> findAllCity() {
		return this.cityDao.findAll();

	}

	@Override
	public void saveCity(City data) {
		 this.cityDao.save(data);
		 throw new RuntimeException("测试事务");
	}
	
}
