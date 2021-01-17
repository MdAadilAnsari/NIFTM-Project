package com.niftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niftm.dto.CollegeRequest;
import com.niftm.entity.College;
import com.niftm.service.ICollegeService;

@RestController
@RequestMapping("/api/college")
public class CollegeController {
	
	@Autowired
	private ICollegeService clgService;
	
	@PostMapping("/save")
	public ResponseEntity<College> saveAndUpdate(@RequestBody CollegeRequest clg){
		College saveCollegeDtls = clgService.saveCollegeDtls(clg);
		return new ResponseEntity<College>(saveCollegeDtls,new HttpHeaders(),HttpStatus.OK);
	}

}
