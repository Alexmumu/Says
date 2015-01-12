package org.service;

import java.util.List;

import org.entity.City;
import org.entity.Province;
import org.springframework.dao.DataAccessException;

public interface IProvinceService {

	/**
	 * 查询所有的省份
	 * @return list集合
	 * @throws DataAccessException
	 */
	public List<Province> findProvince() throws DataAccessException ;
	void saveProvince(Province data);
}
