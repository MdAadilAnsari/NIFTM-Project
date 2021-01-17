package com.niftm.dto;

import lombok.Data;

@Data
public class StudentRequest {
	
	private Long courseId;
	
	private Long cityId;
	
	private Long stateId;
	
	private Long clgId;
	
	private String studentName;
	
	private Long mobileNo;
	
	private String address;
	
	private String emailId;
	
	private String fatherName;
	
	private String motherName;

}
