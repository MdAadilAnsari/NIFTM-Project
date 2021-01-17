package com.niftm.service;
import java.util.List;

import com.niftm.dto.StudentRequest;
import com.niftm.entity.Student;
  
  public interface IStudentService {
  
  public Student saveStudentDtls(StudentRequest student);
  
  public List<Student> getAllStudent();
  
  public Student getStudentById(Long id);
  
  public Boolean deleteStudentById(Long id);
  
  public Student updateStudentDtls(Student std);
  
  }
 