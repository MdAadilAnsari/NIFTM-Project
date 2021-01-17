
  package com.niftm.repository;
  
  import java.io.Serializable;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.niftm.entity.Course;
  
  public interface CourseRepo extends JpaRepository<Course, Serializable> {
  
  }
 