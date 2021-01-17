package com.niftm.service;
import java.util.List;

import com.niftm.dto.CourseRequest;
import com.niftm.entity.Course;
  
  public interface ICourseService {
  
  public Course saveCourseDtls(CourseRequest course);
  
  public List<Course> getAllCourse();
  
  public Course getCourseById(Long id);
  
  public Boolean deleteCourseById(Long id);
  
  public Course updateCourse(Course c);
  
  }
 