package com.niftm.service;

import java.util.List;

import com.niftm.dto.CollegeRequest;
import com.niftm.entity.College;

public interface ICollegeService {
	
	public College saveCollegeDtls(CollegeRequest college);
	
	public List<College> getCollegeDtls();
	
	public Boolean deleteByCollegeId(Integer id);
	
	public College getCollegeById(Integer id);

}
