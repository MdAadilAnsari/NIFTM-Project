package com.niftm.service;

import java.util.List;

import com.niftm.dto.CityRequest;
import com.niftm.entity.City;

public interface ICityService {

	public City saveCityName(CityRequest city);
	
	public List<City> getAllCity();
	
	public City getCityById(Long id);
	
	public Boolean deleteCityBtId(Long id);
	
	public City updateCity(City city);
}
