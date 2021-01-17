package com.niftm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niftm.dto.CourseRequest;
import com.niftm.entity.Course;
import com.niftm.entity.Student;
import com.niftm.repository.CourseRepo;
import com.niftm.repository.StudentRepo;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studRepo;
	
	@Override
	public Course saveCourseDtls(CourseRequest course) {
		Student st = studRepo.findById(course.getStudentId()).orElse(null);
		Course c = new Course();
		c.setCourseName(course.getCourseName());
		c.setStudent(st);
		return courseRepo.save(c);
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepo.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		Optional<Course> findById = courseRepo.findById(id);
		if(findById.isPresent()) {
			Course c = findById.get();
			return c;
		}
		return null;
	}

	@Override
	public Boolean deleteCourseById(Long id) {
		courseRepo.deleteById(id);
		return true;
	}

	@Override
	public Course updateCourse(Course c) {
		Course existingCourse = courseRepo.findById(c.getId()).orElse(null);
		existingCourse.setCourseName(c.getCourseName());
		return courseRepo.save(existingCourse);
	}
	

}
