package com.niftm.dto;

import com.niftm.entity.State;

import lombok.Data;

@Data
public class CityRequest {
	
	private Long stateId;
	
	private String cityName;
}
