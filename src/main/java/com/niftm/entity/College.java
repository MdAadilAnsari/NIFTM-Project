package com.niftm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COLLEGE")
public class College implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5966657752870135658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "college_id",nullable = false)
	private Long id;
	
	@Column(name = "college_name",nullable = false)
	private String collegeName;
	
	@Column(name = "college_address", nullable = false)
	private String collegeAddress;
	
	@Column(name = "college_contact_number",nullable = false)
	private Long phoneNo;

}
