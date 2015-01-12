package org.dao.impl;



import java.util.List;

import org.dao.IProvinceDao;
import org.entity.Province;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinceDaoImpl extends AbstractBaseDao<Province> implements
		IProvinceDao {
     //private static final String FINDPROVINCE_HQL = "select * from Province";
	@Override
	public List<Province> findProvince()  throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println(this.findAll().size());
		return this.findAll();
	}

	
}
