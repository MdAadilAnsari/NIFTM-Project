package com.niftm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niftm.dto.CityRequest;
import com.niftm.entity.City;
import com.niftm.entity.State;
import com.niftm.repository.CityRepo;
import com.niftm.repository.StateRepo;
import com.sun.el.stream.Optional;
@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private StateRepo stateRepo;

	@Override
	public City saveCityName(CityRequest city) {

		State stt = stateRepo.findById(city.getStateId()).orElse(null);
		City ctt = new City();
		ctt.setCityName(city.getCityName());
		ctt.setState(stt);
		return cityRepo.save(ctt);
		
		/*
		 * if(stt.isPresent()) { ctt.setCityName(city.getCityName());
		 * ctt.setId(city.getStateId()); return cityRepo.save(ctt); } return null;
		 */
		 
	}

	@Override
	public List<City> getAllCity() {
		List<City> cityList = cityRepo.findAll();
		if(!cityList.isEmpty()) {
			return cityList;
		}else {
			return new ArrayList<City>();
		}
	}

	@Override
	public Boolean deleteCityBtId(Long id) {
		cityRepo.deleteById(id);
		return true;
	}

	@Override
	public City getCityById(Long id) {
		java.util.Optional<City> findById = cityRepo.findById(id);
		if(findById.isPresent()) {
			City c = findById.get();
			return c;
		}
		return null;
	}

	@Override
	public City updateCity(City city) {
		City existingCity = cityRepo.findById(city.getId()).orElse(null);
		existingCity.setCityName(city.getCityName());
		return cityRepo.save(existingCity);
	}

}
