
  package com.niftm.repository;
  
  import java.io.Serializable;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.niftm.entity.Student;
  
  public interface StudentRepo extends JpaRepository<Student, Serializable> {
  
  }
 