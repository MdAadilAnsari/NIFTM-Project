package com.niftm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niftm.dto.CollegeRequest;
import com.niftm.entity.College;
import com.niftm.repository.CollegeRepo;

@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	private CollegeRepo clgRepo;
	
	@Override
	public College saveCollegeDtls(CollegeRequest college) {
		College clg = new College();
		clg.setCollegeName(college.getCollegeName());
		clg.setCollegeAddress(college.getCollegeAddress());
		clg.setPhoneNo(college.getPhoneNo());
		return clgRepo.save(clg);
	}

	@Override
	public List<College> getCollegeDtls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteByCollegeId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College getCollegeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
