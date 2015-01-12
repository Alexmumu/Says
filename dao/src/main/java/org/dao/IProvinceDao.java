package org.dao;

import java.util.List;

import org.entity.Province;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface IProvinceDao extends IBaseDao<Province>{
	
	public List<Province> findProvince() throws DataAccessException ;

}
