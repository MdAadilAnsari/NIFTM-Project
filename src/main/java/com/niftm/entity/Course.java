
package com.niftm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -720076782254078163L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id",nullable = false)
	private Long id;

	@Column(name = "course_name",nullable = false)
	private String courseName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "stud_id", referencedColumnName = "student_id")
	private Student student;
	 

}
