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
import org.springframework.web.bind.annotation.RestController;

import com.niftm.dto.CourseRequest;
import com.niftm.entity.Course;
import com.niftm.service.ICourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private ICourseService crsService;
	
	@PostMapping("/save")
	public ResponseEntity<Course> saveCourse(@RequestBody CourseRequest course){
		Course saveCourseDtls = crsService.saveCourseDtls(course);
		return new ResponseEntity<Course>(saveCourseDtls,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Course> getAllCourses(){
		return crsService.getAllCourse();
	}

	@GetMapping("/getOne/{id}")
	public Course getSingleCourse(@PathVariable("id")Long id) {
		Course courseById = crsService.getCourseById(id);
		return courseById;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteCourse(@PathVariable("id")Long id) {
		Boolean isDeleted = crsService.deleteCourseById(id);
		return isDeleted;
	}
	
	@PutMapping("/update")
	public Course updateCourseDtls(@RequestBody Course c) {
		Course updateCourse = crsService.updateCourse(c);
		return updateCourse;
	}
}
