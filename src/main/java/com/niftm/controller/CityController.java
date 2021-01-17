package com.niftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niftm.dto.CityRequest;
import com.niftm.entity.City;
import com.niftm.service.ICityService;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	private ICityService cityService;
	
	@PostMapping("/save")
	public ResponseEntity<City> createOrUpdateCity(@RequestBody CityRequest city){
		
		City saveCityName = cityService.saveCityName(city);
		
		return new ResponseEntity<City>(saveCityName,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public List<City> getAllCity(){
		return cityService.getAllCity();
	}
	@GetMapping("/getOne/{id}")
	public City getSingleCity(@PathVariable("id") Long id) {
		City cityById = cityService.getCityById(id);
		return cityById;
	}
	
	@DeleteMapping("/deleteCity/{id}")
	public Boolean deleteCity(@PathVariable("id") Long id) {
		Boolean deleteCityBtId = cityService.deleteCityBtId(id);
		return deleteCityBtId;
	}
	
	@PutMapping("/update")
	public City updateCityDtls(@RequestBody City city) {
		City updateCity = cityService.updateCity(city);
		return updateCity;
	}

}
