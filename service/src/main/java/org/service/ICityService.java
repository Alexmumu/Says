package org.service;

import java.util.List;

import org.entity.City;

public interface ICityService {
	List<City> findAllCity() ;
	void saveCity(City data);
}
