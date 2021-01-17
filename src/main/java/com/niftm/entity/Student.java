
package com.niftm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -4740349768614304702L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id", nullable = false)
	private Long id;

	@Column(name = "student_name", nullable = false)
	private String studentName;

	@Column(name = "mobile_no", nullable = false)
	private Long mobileNo;

	@Column(name = "email_id", nullable = false)
	private String emailId;

	@Column(name = "student_address", nullable = false)
	private String studentAddress;

	@Column(name = "father_name", nullable = false)
	private String fatherName;

	@Column(name = "mother_name", nullable = false)
	private String motherName;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id", referencedColumnName = "state_id")
	private State state;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "clg_id", referencedColumnName = "college_id")
	private College college;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	private City city;
	
	@OneToOne(fetch = FetchType.EAGER,optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id",referencedColumnName = "course_id")
	private Course course;

	/*
	 * @OneToMany(targetEntity = Course.class,mappedBy = "student",fetch =
	 * FetchType.EAGER,cascade = CascadeType.ALL) //@JoinColumn(name =
	 * "course_id",referencedColumnName ="courseId",nullable = false) private
	 * List<Course> course;
	 */

}
